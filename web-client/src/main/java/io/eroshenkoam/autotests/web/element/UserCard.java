package io.eroshenkoam.autotests.web.element;

import io.qameta.atlas.AtlasWebElement;
import io.qameta.atlas.extension.FindBy;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public interface UserCard extends AtlasWebElement<UserCard> {

    @FindBy(".//span[contains(@class, 'p-name')]")
    AtlasWebElement name();

    @FindBy(".//span[contains(@class, 'p-nickname')]")
    AtlasWebElement nickname();

}
