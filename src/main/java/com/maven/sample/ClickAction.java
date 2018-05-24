package com.maven.sample;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.interactions.KeyInput;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.interactions.internal.MouseAction;

import com.google.common.collect.ImmutableList;

/**
 * Clicks an element.
 * @deprecated Use {@link Actions#click(WebElement)}
 */
@Deprecated
public class ClickAction extends MouseAction implements Action {
  public ClickAction(Mouse mouse, Locatable locationProvider) {
    super(mouse, locationProvider);
  }

  public void perform() {
    moveToLocation();
    mouse.click(getActionLocation());
  }

  @Override
  public List<Interaction> asInteractions(PointerInput mouse, KeyInput keyboard) {
    ImmutableList.Builder<Interaction> interactions = ImmutableList.builder();

    moveToLocation(mouse, interactions);
    interactions.add(mouse.createPointerDown(Button.LEFT.asArg()));
    interactions.add(mouse.createPointerUp(Button.LEFT.asArg()));

    return interactions.build();
  }
}