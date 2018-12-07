package io.eroshenkoam.autotests.web.page;

import io.eroshenkoam.autotests.web.element.UserCard;
import io.qameta.atlas.WebPage;
import io.qameta.atlas.extension.FindBy;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public interface UserPage extends WebPage {

    @FindBy(".//div[.//div[contains(@class, 'vcard-names-container')]]")
    UserCard userCard();

}
