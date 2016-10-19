public void layoutContainer(Container container) {
  Insets insets = container.getInsets();
  Dimension westSize = new Dimension(0, 0);
  Dimension centerSize = new Dimension(0, 0);
  Dimension eastSize = new Dimension(0, 0);
  Rectangle centerBounds = new Rectangle(0, 0, 0, 0);
  Dimension containerSize = container.getSize();
  int centerX = containerSize.width / 2;
  int centerY = containerSize.height / 2;
  if ((centerComponent != null) &&
      (centerComponent.isVisible())) {
    centerSize = centerComponent.getPreferredSize();
    centerSize.width = Math.min(centerSize.width,
      containerSize.width - insets.left -
      insets.right);
    centerSize.height = Math.min(centerSize.height,
      containerSize.height - insets.top -
      insets.bottom);
    centerComponent.setBounds(centerX -
      (centerSize.width / 2),
      centerY - (centerSize.height / 2),
      centerSize.width, centerSize.height);
    centerBounds = centerComponent.getBounds();
  }
  if ((westComponent != null) && (westComponent.isVisible())) {
    westSize = westComponent.getPreferredSize();
  }
  if ((eastComponent != null) && (eastComponent.isVisible())) {
    eastSize = eastComponent.getPreferredSize();
  } int maxWidth = Math.min(westSize.width, eastSize.width);
  maxWidth = Math.max(maxWidth, (containerSize.width -
      centerBounds.width - insets.left -
      insets.right) / 2);
  int maxHeight = Math.min(westSize.height, eastSize.height);
  maxHeight = Math.min(maxHeight, containerSize.height -
      insets.top - insets.bottom);
  if (westComponent != null) {
    westComponent.setBounds(centerBounds.x - maxWidth,
        centerY - (maxHeight / 2),
        maxWidth, maxHeight);
  }
  if (eastComponent != null) {
    eastComponent.setBounds(centerBounds.x +
        centerBounds.width,
        centerY - (maxHeight / 2),
        maxWidth, maxHeight);
  }
}
