package io.eroshenkoam.autotests.api.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

/**
 * @author eroshenkoam (Artem Eroshenko).
 * @param <T> - nothing
 */
public final class DefaultCallAdapterFactory<T> extends CallAdapter.Factory {

    //CHECKSTYLE:OFF
    @Override
    public CallAdapter<T, ?> get(final Type returnType, final Annotation[] annotations, final Retrofit retrofit) {
        if (returnType.getTypeName().startsWith(Call.class.getName())) {
            return null;
        }
        if (returnType.getTypeName().startsWith(Response.class.getName())) {
            return new ResponseCallAdapter(((ParameterizedType) returnType).getActualTypeArguments()[0]);
        }
        return new InstanceCallAdapter(returnType);
    }
    //CHECKSTYLE:ON

    private static String getErrorMessage(final Response<?> response) {
        final ResponseBody errorBody = response.errorBody();
        final String errorMessage;
        try {
            errorMessage = Objects.isNull(errorBody) ? response.message() : errorBody.string();
        } catch (IOException e) {
            throw new RetrofitException("Could not read error body", e);
        }
        return errorMessage;
    }

    /**
     * Call adapter factory for Response<...>.
     */
    private class ResponseCallAdapter implements CallAdapter<T, Response<T>> {

        private final Type returnType;

        ResponseCallAdapter(final Type returnType) {
            this.returnType = returnType;
        }

        @Override
        public Type responseType() {
            return returnType;
        }

        @Override
        public Response<T> adapt(final Call<T> call) {
            final Response<T> response;
            try {
                response = call.execute();
            } catch (IOException e) {
                throw new RetrofitException("Could not execute request", e);
            }

            if (!response.isSuccessful()) {
                throw new RetrofitException(getErrorMessage(response));
            }
            return response;
        }
    }

    /**
     * Call adapter factory for instances.
     */
    private class InstanceCallAdapter implements CallAdapter<T, Object> {

        private static final int NOT_FOUND = 404;

        private final Type returnType;

        InstanceCallAdapter(final Type returnType) {
            this.returnType = returnType;
        }

        @Override
        public Type responseType() {
            return returnType;
        }

        @Override
        public Object adapt(final Call<T> call) {
            final Response<T> response;
            try {
                response = call.execute();
            } catch (IOException e) {
                throw new RetrofitException("Could not get request body", e);
            }
            if (!response.isSuccessful()) {
                if (response.code() == NOT_FOUND) {
                    return response.body();
                }
                throw new RetrofitException(getErrorMessage(response));
            }
            return response.body();
        }
    }
}
