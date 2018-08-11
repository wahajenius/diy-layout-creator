package org.diylc.components.connectivity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

import org.diylc.common.Display;
import org.diylc.common.ObjectCache;
import org.diylc.common.SimpleComponentTransformer;
import org.diylc.components.AbstractLeadedComponent;
import org.diylc.core.ComponentState;
import org.diylc.core.CreationMethod;
import org.diylc.core.IDIYComponent;
import org.diylc.core.IDrawingObserver;
import org.diylc.core.Project;
import org.diylc.core.annotations.BomPolicy;
import org.diylc.core.annotations.ComponentDescriptor;
import org.diylc.core.annotations.EditableProperty;
import org.diylc.core.measures.Size;
import org.diylc.core.measures.SizeUnit;

@ComponentDescriptor(name = "Line", author = "Branislav Stojkovic", category = "Shapes",
    creationMethod = CreationMethod.POINT_BY_POINT, instanceNamePrefix = "LN", description = "",
    zOrder = IDIYComponent.COMPONENT, bomPolicy = BomPolicy.NEVER_SHOW, autoEdit = false,
    transformer = SimpleComponentTransformer.class)
public class Line extends AbstractLeadedComponent<Void> {

  private static final long serialVersionUID = 1L;

  public static Color COLOR = Color.black;

  protected Size weight = new Size(0.1d, SizeUnit.mm);
  private Color color = COLOR;

  @Override
  public void drawIcon(Graphics2D g2d, int width, int height) {
    g2d.setStroke(ObjectCache.getInstance().fetchBasicStroke(1));
    g2d.setColor(COLOR);
    g2d.drawLine(1, height - 2, width - 2, 1);
  }

  @Override
  public void draw(Graphics2D g2d, ComponentState componentState, boolean outlineMode, Project project,
      IDrawingObserver drawingObserver) {
    g2d.setStroke(ObjectCache.getInstance().fetchBasicStroke((float)weight.convertToPixels()));
    g2d.setColor(color);
    g2d.drawLine(getControlPoint(0).x, getControlPoint(0).y, getControlPoint(1).x, getControlPoint(1).y);
  }

  @Override
  public Color getLeadColorForPainting(ComponentState componentState) {
    return componentState == ComponentState.SELECTED || componentState == ComponentState.DRAGGING ? SELECTION_COLOR
        : color;
  }

  @Override
  public Color getLeadColor() {
    return super.getLeadColor();
  }

  @EditableProperty
  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  @EditableProperty(name = "Weight", defaultable = true)
  public Size getWeight() {
    return weight;
  }

  public void setWeight(Size weight) {
    this.weight = weight;
  }

  public Color getBodyColor() {
    return super.getBodyColor();
  }

  @Override
  public Color getBorderColor() {
    return super.getBorderColor();
  }

  @Override
  public Byte getAlpha() {
    return super.getAlpha();
  }

  @Override
  public Size getLength() {
    return super.getLength();
  }

  @Override
  public Size getWidth() {
    return super.getWidth();
  }

  @Override
  public Void getValue() {
    return null;
  }

  @Override
  public void setValue(Void value) {}

  @Override
  protected Shape getBodyShape() {
    return null;
  }

  @Override
  protected Size getDefaultWidth() {
    return null;
  }

  @Override
  protected Size getDefaultLength() {
    return null;
  }

  @Deprecated
  @Override
  public Color getLabelColor() {
    return super.getLabelColor();
  }

  @Deprecated
  @Override
  public String getName() {
    return super.getName();
  }

  @Deprecated
  @Override
  public Display getDisplay() {
    return super.getDisplay();
  }
}
