/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.utils;

import java.beans.*;

/**
 *
 * @author Talaco1
 */
public class HintTextFieldBeanInfo extends SimpleBeanInfo {

    // Bean descriptor//GEN-FIRST:BeanDescriptor
    /*lazy BeanDescriptor*/
    private static BeanDescriptor getBdescriptor(){
        BeanDescriptor beanDescriptor = new BeanDescriptor  ( client.utils.HintTextField.class , null ); // NOI18N//GEN-HEADEREND:BeanDescriptor

        // Here you can add code for customizing the BeanDescriptor.

        return beanDescriptor;     }//GEN-LAST:BeanDescriptor
    // Property identifiers//GEN-FIRST:Properties
    private static final int PROPERTY_accessibleContext = 0;
    private static final int PROPERTY_action = 1;
    private static final int PROPERTY_actionCommand = 2;
    private static final int PROPERTY_actionListeners = 3;
    private static final int PROPERTY_actionMap = 4;
    private static final int PROPERTY_actions = 5;
    private static final int PROPERTY_alignmentX = 6;
    private static final int PROPERTY_alignmentY = 7;
    private static final int PROPERTY_ancestorListeners = 8;
    private static final int PROPERTY_autoscrolls = 9;
    private static final int PROPERTY_background = 10;
    private static final int PROPERTY_backgroundSet = 11;
    private static final int PROPERTY_baselineResizeBehavior = 12;
    private static final int PROPERTY_border = 13;
    private static final int PROPERTY_bounds = 14;
    private static final int PROPERTY_caret = 15;
    private static final int PROPERTY_caretColor = 16;
    private static final int PROPERTY_caretListeners = 17;
    private static final int PROPERTY_caretPosition = 18;
    private static final int PROPERTY_colorModel = 19;
    private static final int PROPERTY_columns = 20;
    private static final int PROPERTY_component = 21;
    private static final int PROPERTY_componentCount = 22;
    private static final int PROPERTY_componentListeners = 23;
    private static final int PROPERTY_componentOrientation = 24;
    private static final int PROPERTY_componentPopupMenu = 25;
    private static final int PROPERTY_components = 26;
    private static final int PROPERTY_containerListeners = 27;
    private static final int PROPERTY_cursor = 28;
    private static final int PROPERTY_cursorSet = 29;
    private static final int PROPERTY_debugGraphicsOptions = 30;
    private static final int PROPERTY_disabledTextColor = 31;
    private static final int PROPERTY_displayable = 32;
    private static final int PROPERTY_document = 33;
    private static final int PROPERTY_doubleBuffered = 34;
    private static final int PROPERTY_dragEnabled = 35;
    private static final int PROPERTY_dropLocation = 36;
    private static final int PROPERTY_dropMode = 37;
    private static final int PROPERTY_dropTarget = 38;
    private static final int PROPERTY_editable = 39;
    private static final int PROPERTY_enabled = 40;
    private static final int PROPERTY_focusable = 41;
    private static final int PROPERTY_focusAccelerator = 42;
    private static final int PROPERTY_focusCycleRoot = 43;
    private static final int PROPERTY_focusCycleRootAncestor = 44;
    private static final int PROPERTY_focusListeners = 45;
    private static final int PROPERTY_focusOwner = 46;
    private static final int PROPERTY_focusTraversable = 47;
    private static final int PROPERTY_focusTraversalKeys = 48;
    private static final int PROPERTY_focusTraversalKeysEnabled = 49;
    private static final int PROPERTY_focusTraversalPolicy = 50;
    private static final int PROPERTY_focusTraversalPolicyProvider = 51;
    private static final int PROPERTY_focusTraversalPolicySet = 52;
    private static final int PROPERTY_font = 53;
    private static final int PROPERTY_fontSet = 54;
    private static final int PROPERTY_foreground = 55;
    private static final int PROPERTY_foregroundSet = 56;
    private static final int PROPERTY_graphics = 57;
    private static final int PROPERTY_graphicsConfiguration = 58;
    private static final int PROPERTY_height = 59;
    private static final int PROPERTY_hierarchyBoundsListeners = 60;
    private static final int PROPERTY_hierarchyListeners = 61;
    private static final int PROPERTY_highlighter = 62;
    private static final int PROPERTY_hint = 63;
    private static final int PROPERTY_horizontalAlignment = 64;
    private static final int PROPERTY_horizontalVisibility = 65;
    private static final int PROPERTY_ignoreRepaint = 66;
    private static final int PROPERTY_inheritsPopupMenu = 67;
    private static final int PROPERTY_inputContext = 68;
    private static final int PROPERTY_inputMap = 69;
    private static final int PROPERTY_inputMethodListeners = 70;
    private static final int PROPERTY_inputMethodRequests = 71;
    private static final int PROPERTY_inputVerifier = 72;
    private static final int PROPERTY_insets = 73;
    private static final int PROPERTY_keyListeners = 74;
    private static final int PROPERTY_keymap = 75;
    private static final int PROPERTY_layout = 76;
    private static final int PROPERTY_lightweight = 77;
    private static final int PROPERTY_locale = 78;
    private static final int PROPERTY_location = 79;
    private static final int PROPERTY_locationOnScreen = 80;
    private static final int PROPERTY_managingFocus = 81;
    private static final int PROPERTY_margin = 82;
    private static final int PROPERTY_maximumSize = 83;
    private static final int PROPERTY_maximumSizeSet = 84;
    private static final int PROPERTY_minimumSize = 85;
    private static final int PROPERTY_minimumSizeSet = 86;
    private static final int PROPERTY_mouseListeners = 87;
    private static final int PROPERTY_mouseMotionListeners = 88;
    private static final int PROPERTY_mousePosition = 89;
    private static final int PROPERTY_mouseWheelListeners = 90;
    private static final int PROPERTY_name = 91;
    private static final int PROPERTY_navigationFilter = 92;
    private static final int PROPERTY_nextFocusableComponent = 93;
    private static final int PROPERTY_opaque = 94;
    private static final int PROPERTY_optimizedDrawingEnabled = 95;
    private static final int PROPERTY_paintingForPrint = 96;
    private static final int PROPERTY_paintingTile = 97;
    private static final int PROPERTY_parent = 98;
    private static final int PROPERTY_peer = 99;
    private static final int PROPERTY_preferredScrollableViewportSize = 100;
    private static final int PROPERTY_preferredSize = 101;
    private static final int PROPERTY_preferredSizeSet = 102;
    private static final int PROPERTY_propertyChangeListeners = 103;
    private static final int PROPERTY_registeredKeyStrokes = 104;
    private static final int PROPERTY_requestFocusEnabled = 105;
    private static final int PROPERTY_rootPane = 106;
    private static final int PROPERTY_scrollableTracksViewportHeight = 107;
    private static final int PROPERTY_scrollableTracksViewportWidth = 108;
    private static final int PROPERTY_scrollOffset = 109;
    private static final int PROPERTY_selectedText = 110;
    private static final int PROPERTY_selectedTextColor = 111;
    private static final int PROPERTY_selectionColor = 112;
    private static final int PROPERTY_selectionEnd = 113;
    private static final int PROPERTY_selectionStart = 114;
    private static final int PROPERTY_showing = 115;
    private static final int PROPERTY_size = 116;
    private static final int PROPERTY_text = 117;
    private static final int PROPERTY_toolkit = 118;
    private static final int PROPERTY_toolTipText = 119;
    private static final int PROPERTY_topLevelAncestor = 120;
    private static final int PROPERTY_transferHandler = 121;
    private static final int PROPERTY_treeLock = 122;
    private static final int PROPERTY_UI = 123;
    private static final int PROPERTY_UIClassID = 124;
    private static final int PROPERTY_valid = 125;
    private static final int PROPERTY_validateRoot = 126;
    private static final int PROPERTY_verifyInputWhenFocusTarget = 127;
    private static final int PROPERTY_vetoableChangeListeners = 128;
    private static final int PROPERTY_visible = 129;
    private static final int PROPERTY_visibleRect = 130;
    private static final int PROPERTY_width = 131;
    private static final int PROPERTY_x = 132;
    private static final int PROPERTY_y = 133;

    // Property array 
    /*lazy PropertyDescriptor*/
    private static PropertyDescriptor[] getPdescriptor(){
        PropertyDescriptor[] properties = new PropertyDescriptor[134];
    
        try {
            properties[PROPERTY_accessibleContext] = new PropertyDescriptor ( "accessibleContext", client.utils.HintTextField.class, "getAccessibleContext", null ); // NOI18N
            properties[PROPERTY_action] = new PropertyDescriptor ( "action", client.utils.HintTextField.class, "getAction", "setAction" ); // NOI18N
            properties[PROPERTY_actionCommand] = new PropertyDescriptor ( "actionCommand", client.utils.HintTextField.class, null, "setActionCommand" ); // NOI18N
            properties[PROPERTY_actionListeners] = new PropertyDescriptor ( "actionListeners", client.utils.HintTextField.class, "getActionListeners", null ); // NOI18N
            properties[PROPERTY_actionMap] = new PropertyDescriptor ( "actionMap", client.utils.HintTextField.class, "getActionMap", "setActionMap" ); // NOI18N
            properties[PROPERTY_actions] = new PropertyDescriptor ( "actions", client.utils.HintTextField.class, "getActions", null ); // NOI18N
            properties[PROPERTY_alignmentX] = new PropertyDescriptor ( "alignmentX", client.utils.HintTextField.class, "getAlignmentX", "setAlignmentX" ); // NOI18N
            properties[PROPERTY_alignmentY] = new PropertyDescriptor ( "alignmentY", client.utils.HintTextField.class, "getAlignmentY", "setAlignmentY" ); // NOI18N
            properties[PROPERTY_ancestorListeners] = new PropertyDescriptor ( "ancestorListeners", client.utils.HintTextField.class, "getAncestorListeners", null ); // NOI18N
            properties[PROPERTY_autoscrolls] = new PropertyDescriptor ( "autoscrolls", client.utils.HintTextField.class, "getAutoscrolls", "setAutoscrolls" ); // NOI18N
            properties[PROPERTY_background] = new PropertyDescriptor ( "background", client.utils.HintTextField.class, "getBackground", "setBackground" ); // NOI18N
            properties[PROPERTY_backgroundSet] = new PropertyDescriptor ( "backgroundSet", client.utils.HintTextField.class, "isBackgroundSet", null ); // NOI18N
            properties[PROPERTY_baselineResizeBehavior] = new PropertyDescriptor ( "baselineResizeBehavior", client.utils.HintTextField.class, "getBaselineResizeBehavior", null ); // NOI18N
            properties[PROPERTY_border] = new PropertyDescriptor ( "border", client.utils.HintTextField.class, "getBorder", "setBorder" ); // NOI18N
            properties[PROPERTY_bounds] = new PropertyDescriptor ( "bounds", client.utils.HintTextField.class, "getBounds", "setBounds" ); // NOI18N
            properties[PROPERTY_caret] = new PropertyDescriptor ( "caret", client.utils.HintTextField.class, "getCaret", "setCaret" ); // NOI18N
            properties[PROPERTY_caretColor] = new PropertyDescriptor ( "caretColor", client.utils.HintTextField.class, "getCaretColor", "setCaretColor" ); // NOI18N
            properties[PROPERTY_caretListeners] = new PropertyDescriptor ( "caretListeners", client.utils.HintTextField.class, "getCaretListeners", null ); // NOI18N
            properties[PROPERTY_caretPosition] = new PropertyDescriptor ( "caretPosition", client.utils.HintTextField.class, "getCaretPosition", "setCaretPosition" ); // NOI18N
            properties[PROPERTY_colorModel] = new PropertyDescriptor ( "colorModel", client.utils.HintTextField.class, "getColorModel", null ); // NOI18N
            properties[PROPERTY_columns] = new PropertyDescriptor ( "columns", client.utils.HintTextField.class, "getColumns", "setColumns" ); // NOI18N
            properties[PROPERTY_component] = new IndexedPropertyDescriptor ( "component", client.utils.HintTextField.class, null, null, "getComponent", null ); // NOI18N
            properties[PROPERTY_componentCount] = new PropertyDescriptor ( "componentCount", client.utils.HintTextField.class, "getComponentCount", null ); // NOI18N
            properties[PROPERTY_componentListeners] = new PropertyDescriptor ( "componentListeners", client.utils.HintTextField.class, "getComponentListeners", null ); // NOI18N
            properties[PROPERTY_componentOrientation] = new PropertyDescriptor ( "componentOrientation", client.utils.HintTextField.class, "getComponentOrientation", "setComponentOrientation" ); // NOI18N
            properties[PROPERTY_componentPopupMenu] = new PropertyDescriptor ( "componentPopupMenu", client.utils.HintTextField.class, "getComponentPopupMenu", "setComponentPopupMenu" ); // NOI18N
            properties[PROPERTY_components] = new PropertyDescriptor ( "components", client.utils.HintTextField.class, "getComponents", null ); // NOI18N
            properties[PROPERTY_containerListeners] = new PropertyDescriptor ( "containerListeners", client.utils.HintTextField.class, "getContainerListeners", null ); // NOI18N
            properties[PROPERTY_cursor] = new PropertyDescriptor ( "cursor", client.utils.HintTextField.class, "getCursor", "setCursor" ); // NOI18N
            properties[PROPERTY_cursorSet] = new PropertyDescriptor ( "cursorSet", client.utils.HintTextField.class, "isCursorSet", null ); // NOI18N
            properties[PROPERTY_debugGraphicsOptions] = new PropertyDescriptor ( "debugGraphicsOptions", client.utils.HintTextField.class, "getDebugGraphicsOptions", "setDebugGraphicsOptions" ); // NOI18N
            properties[PROPERTY_disabledTextColor] = new PropertyDescriptor ( "disabledTextColor", client.utils.HintTextField.class, "getDisabledTextColor", "setDisabledTextColor" ); // NOI18N
            properties[PROPERTY_displayable] = new PropertyDescriptor ( "displayable", client.utils.HintTextField.class, "isDisplayable", null ); // NOI18N
            properties[PROPERTY_document] = new PropertyDescriptor ( "document", client.utils.HintTextField.class, "getDocument", "setDocument" ); // NOI18N
            properties[PROPERTY_doubleBuffered] = new PropertyDescriptor ( "doubleBuffered", client.utils.HintTextField.class, "isDoubleBuffered", "setDoubleBuffered" ); // NOI18N
            properties[PROPERTY_dragEnabled] = new PropertyDescriptor ( "dragEnabled", client.utils.HintTextField.class, "getDragEnabled", "setDragEnabled" ); // NOI18N
            properties[PROPERTY_dropLocation] = new PropertyDescriptor ( "dropLocation", client.utils.HintTextField.class, "getDropLocation", null ); // NOI18N
            properties[PROPERTY_dropMode] = new PropertyDescriptor ( "dropMode", client.utils.HintTextField.class, "getDropMode", "setDropMode" ); // NOI18N
            properties[PROPERTY_dropTarget] = new PropertyDescriptor ( "dropTarget", client.utils.HintTextField.class, "getDropTarget", "setDropTarget" ); // NOI18N
            properties[PROPERTY_editable] = new PropertyDescriptor ( "editable", client.utils.HintTextField.class, "isEditable", "setEditable" ); // NOI18N
            properties[PROPERTY_enabled] = new PropertyDescriptor ( "enabled", client.utils.HintTextField.class, "isEnabled", "setEnabled" ); // NOI18N
            properties[PROPERTY_focusable] = new PropertyDescriptor ( "focusable", client.utils.HintTextField.class, "isFocusable", "setFocusable" ); // NOI18N
            properties[PROPERTY_focusAccelerator] = new PropertyDescriptor ( "focusAccelerator", client.utils.HintTextField.class, "getFocusAccelerator", "setFocusAccelerator" ); // NOI18N
            properties[PROPERTY_focusCycleRoot] = new PropertyDescriptor ( "focusCycleRoot", client.utils.HintTextField.class, "isFocusCycleRoot", "setFocusCycleRoot" ); // NOI18N
            properties[PROPERTY_focusCycleRootAncestor] = new PropertyDescriptor ( "focusCycleRootAncestor", client.utils.HintTextField.class, "getFocusCycleRootAncestor", null ); // NOI18N
            properties[PROPERTY_focusListeners] = new PropertyDescriptor ( "focusListeners", client.utils.HintTextField.class, "getFocusListeners", null ); // NOI18N
            properties[PROPERTY_focusOwner] = new PropertyDescriptor ( "focusOwner", client.utils.HintTextField.class, "isFocusOwner", null ); // NOI18N
            properties[PROPERTY_focusTraversable] = new PropertyDescriptor ( "focusTraversable", client.utils.HintTextField.class, "isFocusTraversable", null ); // NOI18N
            properties[PROPERTY_focusTraversalKeys] = new IndexedPropertyDescriptor ( "focusTraversalKeys", client.utils.HintTextField.class, null, null, null, "setFocusTraversalKeys" ); // NOI18N
            properties[PROPERTY_focusTraversalKeysEnabled] = new PropertyDescriptor ( "focusTraversalKeysEnabled", client.utils.HintTextField.class, "getFocusTraversalKeysEnabled", "setFocusTraversalKeysEnabled" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicy] = new PropertyDescriptor ( "focusTraversalPolicy", client.utils.HintTextField.class, "getFocusTraversalPolicy", "setFocusTraversalPolicy" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicyProvider] = new PropertyDescriptor ( "focusTraversalPolicyProvider", client.utils.HintTextField.class, "isFocusTraversalPolicyProvider", "setFocusTraversalPolicyProvider" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicySet] = new PropertyDescriptor ( "focusTraversalPolicySet", client.utils.HintTextField.class, "isFocusTraversalPolicySet", null ); // NOI18N
            properties[PROPERTY_font] = new PropertyDescriptor ( "font", client.utils.HintTextField.class, "getFont", "setFont" ); // NOI18N
            properties[PROPERTY_fontSet] = new PropertyDescriptor ( "fontSet", client.utils.HintTextField.class, "isFontSet", null ); // NOI18N
            properties[PROPERTY_foreground] = new PropertyDescriptor ( "foreground", client.utils.HintTextField.class, "getForeground", "setForeground" ); // NOI18N
            properties[PROPERTY_foregroundSet] = new PropertyDescriptor ( "foregroundSet", client.utils.HintTextField.class, "isForegroundSet", null ); // NOI18N
            properties[PROPERTY_graphics] = new PropertyDescriptor ( "graphics", client.utils.HintTextField.class, "getGraphics", null ); // NOI18N
            properties[PROPERTY_graphicsConfiguration] = new PropertyDescriptor ( "graphicsConfiguration", client.utils.HintTextField.class, "getGraphicsConfiguration", null ); // NOI18N
            properties[PROPERTY_height] = new PropertyDescriptor ( "height", client.utils.HintTextField.class, "getHeight", null ); // NOI18N
            properties[PROPERTY_hierarchyBoundsListeners] = new PropertyDescriptor ( "hierarchyBoundsListeners", client.utils.HintTextField.class, "getHierarchyBoundsListeners", null ); // NOI18N
            properties[PROPERTY_hierarchyListeners] = new PropertyDescriptor ( "hierarchyListeners", client.utils.HintTextField.class, "getHierarchyListeners", null ); // NOI18N
            properties[PROPERTY_highlighter] = new PropertyDescriptor ( "highlighter", client.utils.HintTextField.class, "getHighlighter", "setHighlighter" ); // NOI18N
            properties[PROPERTY_hint] = new PropertyDescriptor ( "hint", client.utils.HintTextField.class, "getHint", "setHint" ); // NOI18N
            properties[PROPERTY_horizontalAlignment] = new PropertyDescriptor ( "horizontalAlignment", client.utils.HintTextField.class, "getHorizontalAlignment", "setHorizontalAlignment" ); // NOI18N
            properties[PROPERTY_horizontalVisibility] = new PropertyDescriptor ( "horizontalVisibility", client.utils.HintTextField.class, "getHorizontalVisibility", null ); // NOI18N
            properties[PROPERTY_ignoreRepaint] = new PropertyDescriptor ( "ignoreRepaint", client.utils.HintTextField.class, "getIgnoreRepaint", "setIgnoreRepaint" ); // NOI18N
            properties[PROPERTY_inheritsPopupMenu] = new PropertyDescriptor ( "inheritsPopupMenu", client.utils.HintTextField.class, "getInheritsPopupMenu", "setInheritsPopupMenu" ); // NOI18N
            properties[PROPERTY_inputContext] = new PropertyDescriptor ( "inputContext", client.utils.HintTextField.class, "getInputContext", null ); // NOI18N
            properties[PROPERTY_inputMap] = new PropertyDescriptor ( "inputMap", client.utils.HintTextField.class, "getInputMap", null ); // NOI18N
            properties[PROPERTY_inputMethodListeners] = new PropertyDescriptor ( "inputMethodListeners", client.utils.HintTextField.class, "getInputMethodListeners", null ); // NOI18N
            properties[PROPERTY_inputMethodRequests] = new PropertyDescriptor ( "inputMethodRequests", client.utils.HintTextField.class, "getInputMethodRequests", null ); // NOI18N
            properties[PROPERTY_inputVerifier] = new PropertyDescriptor ( "inputVerifier", client.utils.HintTextField.class, "getInputVerifier", "setInputVerifier" ); // NOI18N
            properties[PROPERTY_insets] = new PropertyDescriptor ( "insets", client.utils.HintTextField.class, "getInsets", null ); // NOI18N
            properties[PROPERTY_keyListeners] = new PropertyDescriptor ( "keyListeners", client.utils.HintTextField.class, "getKeyListeners", null ); // NOI18N
            properties[PROPERTY_keymap] = new PropertyDescriptor ( "keymap", client.utils.HintTextField.class, "getKeymap", "setKeymap" ); // NOI18N
            properties[PROPERTY_layout] = new PropertyDescriptor ( "layout", client.utils.HintTextField.class, "getLayout", "setLayout" ); // NOI18N
            properties[PROPERTY_lightweight] = new PropertyDescriptor ( "lightweight", client.utils.HintTextField.class, "isLightweight", null ); // NOI18N
            properties[PROPERTY_locale] = new PropertyDescriptor ( "locale", client.utils.HintTextField.class, "getLocale", "setLocale" ); // NOI18N
            properties[PROPERTY_location] = new PropertyDescriptor ( "location", client.utils.HintTextField.class, "getLocation", "setLocation" ); // NOI18N
            properties[PROPERTY_locationOnScreen] = new PropertyDescriptor ( "locationOnScreen", client.utils.HintTextField.class, "getLocationOnScreen", null ); // NOI18N
            properties[PROPERTY_managingFocus] = new PropertyDescriptor ( "managingFocus", client.utils.HintTextField.class, "isManagingFocus", null ); // NOI18N
            properties[PROPERTY_margin] = new PropertyDescriptor ( "margin", client.utils.HintTextField.class, "getMargin", "setMargin" ); // NOI18N
            properties[PROPERTY_maximumSize] = new PropertyDescriptor ( "maximumSize", client.utils.HintTextField.class, "getMaximumSize", "setMaximumSize" ); // NOI18N
            properties[PROPERTY_maximumSizeSet] = new PropertyDescriptor ( "maximumSizeSet", client.utils.HintTextField.class, "isMaximumSizeSet", null ); // NOI18N
            properties[PROPERTY_minimumSize] = new PropertyDescriptor ( "minimumSize", client.utils.HintTextField.class, "getMinimumSize", "setMinimumSize" ); // NOI18N
            properties[PROPERTY_minimumSizeSet] = new PropertyDescriptor ( "minimumSizeSet", client.utils.HintTextField.class, "isMinimumSizeSet", null ); // NOI18N
            properties[PROPERTY_mouseListeners] = new PropertyDescriptor ( "mouseListeners", client.utils.HintTextField.class, "getMouseListeners", null ); // NOI18N
            properties[PROPERTY_mouseMotionListeners] = new PropertyDescriptor ( "mouseMotionListeners", client.utils.HintTextField.class, "getMouseMotionListeners", null ); // NOI18N
            properties[PROPERTY_mousePosition] = new PropertyDescriptor ( "mousePosition", client.utils.HintTextField.class, "getMousePosition", null ); // NOI18N
            properties[PROPERTY_mouseWheelListeners] = new PropertyDescriptor ( "mouseWheelListeners", client.utils.HintTextField.class, "getMouseWheelListeners", null ); // NOI18N
            properties[PROPERTY_name] = new PropertyDescriptor ( "name", client.utils.HintTextField.class, "getName", "setName" ); // NOI18N
            properties[PROPERTY_navigationFilter] = new PropertyDescriptor ( "navigationFilter", client.utils.HintTextField.class, "getNavigationFilter", "setNavigationFilter" ); // NOI18N
            properties[PROPERTY_nextFocusableComponent] = new PropertyDescriptor ( "nextFocusableComponent", client.utils.HintTextField.class, "getNextFocusableComponent", "setNextFocusableComponent" ); // NOI18N
            properties[PROPERTY_opaque] = new PropertyDescriptor ( "opaque", client.utils.HintTextField.class, "isOpaque", "setOpaque" ); // NOI18N
            properties[PROPERTY_optimizedDrawingEnabled] = new PropertyDescriptor ( "optimizedDrawingEnabled", client.utils.HintTextField.class, "isOptimizedDrawingEnabled", null ); // NOI18N
            properties[PROPERTY_paintingForPrint] = new PropertyDescriptor ( "paintingForPrint", client.utils.HintTextField.class, "isPaintingForPrint", null ); // NOI18N
            properties[PROPERTY_paintingTile] = new PropertyDescriptor ( "paintingTile", client.utils.HintTextField.class, "isPaintingTile", null ); // NOI18N
            properties[PROPERTY_parent] = new PropertyDescriptor ( "parent", client.utils.HintTextField.class, "getParent", null ); // NOI18N
            properties[PROPERTY_peer] = new PropertyDescriptor ( "peer", client.utils.HintTextField.class, "getPeer", null ); // NOI18N
            properties[PROPERTY_preferredScrollableViewportSize] = new PropertyDescriptor ( "preferredScrollableViewportSize", client.utils.HintTextField.class, "getPreferredScrollableViewportSize", null ); // NOI18N
            properties[PROPERTY_preferredSize] = new PropertyDescriptor ( "preferredSize", client.utils.HintTextField.class, "getPreferredSize", "setPreferredSize" ); // NOI18N
            properties[PROPERTY_preferredSizeSet] = new PropertyDescriptor ( "preferredSizeSet", client.utils.HintTextField.class, "isPreferredSizeSet", null ); // NOI18N
            properties[PROPERTY_propertyChangeListeners] = new PropertyDescriptor ( "propertyChangeListeners", client.utils.HintTextField.class, "getPropertyChangeListeners", null ); // NOI18N
            properties[PROPERTY_registeredKeyStrokes] = new PropertyDescriptor ( "registeredKeyStrokes", client.utils.HintTextField.class, "getRegisteredKeyStrokes", null ); // NOI18N
            properties[PROPERTY_requestFocusEnabled] = new PropertyDescriptor ( "requestFocusEnabled", client.utils.HintTextField.class, "isRequestFocusEnabled", "setRequestFocusEnabled" ); // NOI18N
            properties[PROPERTY_rootPane] = new PropertyDescriptor ( "rootPane", client.utils.HintTextField.class, "getRootPane", null ); // NOI18N
            properties[PROPERTY_scrollableTracksViewportHeight] = new PropertyDescriptor ( "scrollableTracksViewportHeight", client.utils.HintTextField.class, "getScrollableTracksViewportHeight", null ); // NOI18N
            properties[PROPERTY_scrollableTracksViewportWidth] = new PropertyDescriptor ( "scrollableTracksViewportWidth", client.utils.HintTextField.class, "getScrollableTracksViewportWidth", null ); // NOI18N
            properties[PROPERTY_scrollOffset] = new PropertyDescriptor ( "scrollOffset", client.utils.HintTextField.class, "getScrollOffset", "setScrollOffset" ); // NOI18N
            properties[PROPERTY_selectedText] = new PropertyDescriptor ( "selectedText", client.utils.HintTextField.class, "getSelectedText", null ); // NOI18N
            properties[PROPERTY_selectedTextColor] = new PropertyDescriptor ( "selectedTextColor", client.utils.HintTextField.class, "getSelectedTextColor", "setSelectedTextColor" ); // NOI18N
            properties[PROPERTY_selectionColor] = new PropertyDescriptor ( "selectionColor", client.utils.HintTextField.class, "getSelectionColor", "setSelectionColor" ); // NOI18N
            properties[PROPERTY_selectionEnd] = new PropertyDescriptor ( "selectionEnd", client.utils.HintTextField.class, "getSelectionEnd", "setSelectionEnd" ); // NOI18N
            properties[PROPERTY_selectionStart] = new PropertyDescriptor ( "selectionStart", client.utils.HintTextField.class, "getSelectionStart", "setSelectionStart" ); // NOI18N
            properties[PROPERTY_showing] = new PropertyDescriptor ( "showing", client.utils.HintTextField.class, "isShowing", null ); // NOI18N
            properties[PROPERTY_size] = new PropertyDescriptor ( "size", client.utils.HintTextField.class, "getSize", "setSize" ); // NOI18N
            properties[PROPERTY_text] = new PropertyDescriptor ( "text", client.utils.HintTextField.class, "getText", "setText" ); // NOI18N
            properties[PROPERTY_toolkit] = new PropertyDescriptor ( "toolkit", client.utils.HintTextField.class, "getToolkit", null ); // NOI18N
            properties[PROPERTY_toolTipText] = new PropertyDescriptor ( "toolTipText", client.utils.HintTextField.class, "getToolTipText", "setToolTipText" ); // NOI18N
            properties[PROPERTY_topLevelAncestor] = new PropertyDescriptor ( "topLevelAncestor", client.utils.HintTextField.class, "getTopLevelAncestor", null ); // NOI18N
            properties[PROPERTY_transferHandler] = new PropertyDescriptor ( "transferHandler", client.utils.HintTextField.class, "getTransferHandler", "setTransferHandler" ); // NOI18N
            properties[PROPERTY_treeLock] = new PropertyDescriptor ( "treeLock", client.utils.HintTextField.class, "getTreeLock", null ); // NOI18N
            properties[PROPERTY_UI] = new PropertyDescriptor ( "UI", client.utils.HintTextField.class, "getUI", "setUI" ); // NOI18N
            properties[PROPERTY_UIClassID] = new PropertyDescriptor ( "UIClassID", client.utils.HintTextField.class, "getUIClassID", null ); // NOI18N
            properties[PROPERTY_valid] = new PropertyDescriptor ( "valid", client.utils.HintTextField.class, "isValid", null ); // NOI18N
            properties[PROPERTY_validateRoot] = new PropertyDescriptor ( "validateRoot", client.utils.HintTextField.class, "isValidateRoot", null ); // NOI18N
            properties[PROPERTY_verifyInputWhenFocusTarget] = new PropertyDescriptor ( "verifyInputWhenFocusTarget", client.utils.HintTextField.class, "getVerifyInputWhenFocusTarget", "setVerifyInputWhenFocusTarget" ); // NOI18N
            properties[PROPERTY_vetoableChangeListeners] = new PropertyDescriptor ( "vetoableChangeListeners", client.utils.HintTextField.class, "getVetoableChangeListeners", null ); // NOI18N
            properties[PROPERTY_visible] = new PropertyDescriptor ( "visible", client.utils.HintTextField.class, "isVisible", "setVisible" ); // NOI18N
            properties[PROPERTY_visibleRect] = new PropertyDescriptor ( "visibleRect", client.utils.HintTextField.class, "getVisibleRect", null ); // NOI18N
            properties[PROPERTY_width] = new PropertyDescriptor ( "width", client.utils.HintTextField.class, "getWidth", null ); // NOI18N
            properties[PROPERTY_x] = new PropertyDescriptor ( "x", client.utils.HintTextField.class, "getX", null ); // NOI18N
            properties[PROPERTY_y] = new PropertyDescriptor ( "y", client.utils.HintTextField.class, "getY", null ); // NOI18N
        }
        catch(IntrospectionException e) {
            e.printStackTrace();
        }//GEN-HEADEREND:Properties

        // Here you can add code for customizing the properties array.

        return properties;     }//GEN-LAST:Properties
    // EventSet identifiers//GEN-FIRST:Events
    private static final int EVENT_actionListener = 0;
    private static final int EVENT_ancestorListener = 1;
    private static final int EVENT_caretListener = 2;
    private static final int EVENT_componentListener = 3;
    private static final int EVENT_containerListener = 4;
    private static final int EVENT_focusListener = 5;
    private static final int EVENT_hierarchyBoundsListener = 6;
    private static final int EVENT_hierarchyListener = 7;
    private static final int EVENT_inputMethodListener = 8;
    private static final int EVENT_keyListener = 9;
    private static final int EVENT_mouseListener = 10;
    private static final int EVENT_mouseMotionListener = 11;
    private static final int EVENT_mouseWheelListener = 12;
    private static final int EVENT_propertyChangeListener = 13;
    private static final int EVENT_vetoableChangeListener = 14;

    // EventSet array
    /*lazy EventSetDescriptor*/
    private static EventSetDescriptor[] getEdescriptor(){
        EventSetDescriptor[] eventSets = new EventSetDescriptor[15];
    
        try {
            eventSets[EVENT_actionListener] = new EventSetDescriptor ( client.utils.HintTextField.class, "actionListener", java.awt.event.ActionListener.class, new String[] {"actionPerformed"}, "addActionListener", "removeActionListener" ); // NOI18N
            eventSets[EVENT_ancestorListener] = new EventSetDescriptor ( client.utils.HintTextField.class, "ancestorListener", javax.swing.event.AncestorListener.class, new String[] {"ancestorAdded", "ancestorRemoved", "ancestorMoved"}, "addAncestorListener", "removeAncestorListener" ); // NOI18N
            eventSets[EVENT_caretListener] = new EventSetDescriptor ( client.utils.HintTextField.class, "caretListener", javax.swing.event.CaretListener.class, new String[] {"caretUpdate"}, "addCaretListener", "removeCaretListener" ); // NOI18N
            eventSets[EVENT_componentListener] = new EventSetDescriptor ( client.utils.HintTextField.class, "componentListener", java.awt.event.ComponentListener.class, new String[] {"componentResized", "componentMoved", "componentShown", "componentHidden"}, "addComponentListener", "removeComponentListener" ); // NOI18N
            eventSets[EVENT_containerListener] = new EventSetDescriptor ( client.utils.HintTextField.class, "containerListener", java.awt.event.ContainerListener.class, new String[] {"componentAdded", "componentRemoved"}, "addContainerListener", "removeContainerListener" ); // NOI18N
            eventSets[EVENT_focusListener] = new EventSetDescriptor ( client.utils.HintTextField.class, "focusListener", java.awt.event.FocusListener.class, new String[] {"focusGained", "focusLost"}, "addFocusListener", "removeFocusListener" ); // NOI18N
            eventSets[EVENT_hierarchyBoundsListener] = new EventSetDescriptor ( client.utils.HintTextField.class, "hierarchyBoundsListener", java.awt.event.HierarchyBoundsListener.class, new String[] {"ancestorMoved", "ancestorResized"}, "addHierarchyBoundsListener", "removeHierarchyBoundsListener" ); // NOI18N
            eventSets[EVENT_hierarchyListener] = new EventSetDescriptor ( client.utils.HintTextField.class, "hierarchyListener", java.awt.event.HierarchyListener.class, new String[] {"hierarchyChanged"}, "addHierarchyListener", "removeHierarchyListener" ); // NOI18N
            eventSets[EVENT_inputMethodListener] = new EventSetDescriptor ( client.utils.HintTextField.class, "inputMethodListener", java.awt.event.InputMethodListener.class, new String[] {"inputMethodTextChanged", "caretPositionChanged"}, "addInputMethodListener", "removeInputMethodListener" ); // NOI18N
            eventSets[EVENT_keyListener] = new EventSetDescriptor ( client.utils.HintTextField.class, "keyListener", java.awt.event.KeyListener.class, new String[] {"keyTyped", "keyPressed", "keyReleased"}, "addKeyListener", "removeKeyListener" ); // NOI18N
            eventSets[EVENT_mouseListener] = new EventSetDescriptor ( client.utils.HintTextField.class, "mouseListener", java.awt.event.MouseListener.class, new String[] {"mouseClicked", "mousePressed", "mouseReleased", "mouseEntered", "mouseExited"}, "addMouseListener", "removeMouseListener" ); // NOI18N
            eventSets[EVENT_mouseMotionListener] = new EventSetDescriptor ( client.utils.HintTextField.class, "mouseMotionListener", java.awt.event.MouseMotionListener.class, new String[] {"mouseDragged", "mouseMoved"}, "addMouseMotionListener", "removeMouseMotionListener" ); // NOI18N
            eventSets[EVENT_mouseWheelListener] = new EventSetDescriptor ( client.utils.HintTextField.class, "mouseWheelListener", java.awt.event.MouseWheelListener.class, new String[] {"mouseWheelMoved"}, "addMouseWheelListener", "removeMouseWheelListener" ); // NOI18N
            eventSets[EVENT_propertyChangeListener] = new EventSetDescriptor ( client.utils.HintTextField.class, "propertyChangeListener", java.beans.PropertyChangeListener.class, new String[] {"propertyChange"}, "addPropertyChangeListener", "removePropertyChangeListener" ); // NOI18N
            eventSets[EVENT_vetoableChangeListener] = new EventSetDescriptor ( client.utils.HintTextField.class, "vetoableChangeListener", java.beans.VetoableChangeListener.class, new String[] {"vetoableChange"}, "addVetoableChangeListener", "removeVetoableChangeListener" ); // NOI18N
        }
        catch(IntrospectionException e) {
            e.printStackTrace();
        }//GEN-HEADEREND:Events

        // Here you can add code for customizing the event sets array.

        return eventSets;     }//GEN-LAST:Events
    // Method identifiers//GEN-FIRST:Methods
    private static final int METHOD_action0 = 0;
    private static final int METHOD_add1 = 1;
    private static final int METHOD_add2 = 2;
    private static final int METHOD_add3 = 3;
    private static final int METHOD_add4 = 4;
    private static final int METHOD_add5 = 5;
    private static final int METHOD_add6 = 6;
    private static final int METHOD_addKeymap7 = 7;
    private static final int METHOD_addNotify8 = 8;
    private static final int METHOD_addPropertyChangeListener9 = 9;
    private static final int METHOD_applyComponentOrientation10 = 10;
    private static final int METHOD_areFocusTraversalKeysSet11 = 11;
    private static final int METHOD_bounds12 = 12;
    private static final int METHOD_checkImage13 = 13;
    private static final int METHOD_checkImage14 = 14;
    private static final int METHOD_computeVisibleRect15 = 15;
    private static final int METHOD_contains16 = 16;
    private static final int METHOD_contains17 = 17;
    private static final int METHOD_copy18 = 18;
    private static final int METHOD_countComponents19 = 19;
    private static final int METHOD_createImage20 = 20;
    private static final int METHOD_createImage21 = 21;
    private static final int METHOD_createToolTip22 = 22;
    private static final int METHOD_createVolatileImage23 = 23;
    private static final int METHOD_createVolatileImage24 = 24;
    private static final int METHOD_cut25 = 25;
    private static final int METHOD_deliverEvent26 = 26;
    private static final int METHOD_disable27 = 27;
    private static final int METHOD_dispatchEvent28 = 28;
    private static final int METHOD_doLayout29 = 29;
    private static final int METHOD_enable30 = 30;
    private static final int METHOD_enable31 = 31;
    private static final int METHOD_enableInputMethods32 = 32;
    private static final int METHOD_findComponentAt33 = 33;
    private static final int METHOD_findComponentAt34 = 34;
    private static final int METHOD_firePropertyChange35 = 35;
    private static final int METHOD_firePropertyChange36 = 36;
    private static final int METHOD_firePropertyChange37 = 37;
    private static final int METHOD_firePropertyChange38 = 38;
    private static final int METHOD_firePropertyChange39 = 39;
    private static final int METHOD_firePropertyChange40 = 40;
    private static final int METHOD_firePropertyChange41 = 41;
    private static final int METHOD_firePropertyChange42 = 42;
    private static final int METHOD_focusGained43 = 43;
    private static final int METHOD_focusLost44 = 44;
    private static final int METHOD_getActionForKeyStroke45 = 45;
    private static final int METHOD_getBaseline46 = 46;
    private static final int METHOD_getBounds47 = 47;
    private static final int METHOD_getClientProperty48 = 48;
    private static final int METHOD_getComponentAt49 = 49;
    private static final int METHOD_getComponentAt50 = 50;
    private static final int METHOD_getComponentZOrder51 = 51;
    private static final int METHOD_getConditionForKeyStroke52 = 52;
    private static final int METHOD_getDefaultLocale53 = 53;
    private static final int METHOD_getFocusTraversalKeys54 = 54;
    private static final int METHOD_getFontMetrics55 = 55;
    private static final int METHOD_getInsets56 = 56;
    private static final int METHOD_getKeymap57 = 57;
    private static final int METHOD_getListeners58 = 58;
    private static final int METHOD_getLocation59 = 59;
    private static final int METHOD_getMousePosition60 = 60;
    private static final int METHOD_getPopupLocation61 = 61;
    private static final int METHOD_getPrintable62 = 62;
    private static final int METHOD_getPropertyChangeListeners63 = 63;
    private static final int METHOD_getScrollableBlockIncrement64 = 64;
    private static final int METHOD_getScrollableUnitIncrement65 = 65;
    private static final int METHOD_getSize66 = 66;
    private static final int METHOD_getText67 = 67;
    private static final int METHOD_getToolTipLocation68 = 68;
    private static final int METHOD_getToolTipText69 = 69;
    private static final int METHOD_gotFocus70 = 70;
    private static final int METHOD_grabFocus71 = 71;
    private static final int METHOD_handleEvent72 = 72;
    private static final int METHOD_hasFocus73 = 73;
    private static final int METHOD_hide74 = 74;
    private static final int METHOD_imageUpdate75 = 75;
    private static final int METHOD_insets76 = 76;
    private static final int METHOD_inside77 = 77;
    private static final int METHOD_invalidate78 = 78;
    private static final int METHOD_isAncestorOf79 = 79;
    private static final int METHOD_isFocusCycleRoot80 = 80;
    private static final int METHOD_isLightweightComponent81 = 81;
    private static final int METHOD_keyDown82 = 82;
    private static final int METHOD_keyUp83 = 83;
    private static final int METHOD_layout84 = 84;
    private static final int METHOD_list85 = 85;
    private static final int METHOD_list86 = 86;
    private static final int METHOD_list87 = 87;
    private static final int METHOD_list88 = 88;
    private static final int METHOD_list89 = 89;
    private static final int METHOD_loadKeymap90 = 90;
    private static final int METHOD_locate91 = 91;
    private static final int METHOD_location92 = 92;
    private static final int METHOD_lostFocus93 = 93;
    private static final int METHOD_minimumSize94 = 94;
    private static final int METHOD_modelToView95 = 95;
    private static final int METHOD_mouseDown96 = 96;
    private static final int METHOD_mouseDrag97 = 97;
    private static final int METHOD_mouseEnter98 = 98;
    private static final int METHOD_mouseExit99 = 99;
    private static final int METHOD_mouseMove100 = 100;
    private static final int METHOD_mouseUp101 = 101;
    private static final int METHOD_move102 = 102;
    private static final int METHOD_moveCaretPosition103 = 103;
    private static final int METHOD_nextFocus104 = 104;
    private static final int METHOD_paint105 = 105;
    private static final int METHOD_paintAll106 = 106;
    private static final int METHOD_paintComponents107 = 107;
    private static final int METHOD_paintImmediately108 = 108;
    private static final int METHOD_paintImmediately109 = 109;
    private static final int METHOD_paste110 = 110;
    private static final int METHOD_postActionEvent111 = 111;
    private static final int METHOD_postEvent112 = 112;
    private static final int METHOD_preferredSize113 = 113;
    private static final int METHOD_prepareImage114 = 114;
    private static final int METHOD_prepareImage115 = 115;
    private static final int METHOD_print116 = 116;
    private static final int METHOD_print117 = 117;
    private static final int METHOD_print118 = 118;
    private static final int METHOD_print119 = 119;
    private static final int METHOD_printAll120 = 120;
    private static final int METHOD_printComponents121 = 121;
    private static final int METHOD_putClientProperty122 = 122;
    private static final int METHOD_read123 = 123;
    private static final int METHOD_registerKeyboardAction124 = 124;
    private static final int METHOD_registerKeyboardAction125 = 125;
    private static final int METHOD_remove126 = 126;
    private static final int METHOD_remove127 = 127;
    private static final int METHOD_remove128 = 128;
    private static final int METHOD_removeAll129 = 129;
    private static final int METHOD_removeKeymap130 = 130;
    private static final int METHOD_removeNotify131 = 131;
    private static final int METHOD_removePropertyChangeListener132 = 132;
    private static final int METHOD_repaint133 = 133;
    private static final int METHOD_repaint134 = 134;
    private static final int METHOD_repaint135 = 135;
    private static final int METHOD_repaint136 = 136;
    private static final int METHOD_repaint137 = 137;
    private static final int METHOD_replaceSelection138 = 138;
    private static final int METHOD_requestDefaultFocus139 = 139;
    private static final int METHOD_requestFocus140 = 140;
    private static final int METHOD_requestFocus141 = 141;
    private static final int METHOD_requestFocusInWindow142 = 142;
    private static final int METHOD_resetKeyboardActions143 = 143;
    private static final int METHOD_reshape144 = 144;
    private static final int METHOD_resize145 = 145;
    private static final int METHOD_resize146 = 146;
    private static final int METHOD_revalidate147 = 147;
    private static final int METHOD_scrollRectToVisible148 = 148;
    private static final int METHOD_select149 = 149;
    private static final int METHOD_selectAll150 = 150;
    private static final int METHOD_setBounds151 = 151;
    private static final int METHOD_setComponentZOrder152 = 152;
    private static final int METHOD_setDefaultLocale153 = 153;
    private static final int METHOD_show154 = 154;
    private static final int METHOD_show155 = 155;
    private static final int METHOD_size156 = 156;
    private static final int METHOD_toString157 = 157;
    private static final int METHOD_transferFocus158 = 158;
    private static final int METHOD_transferFocusBackward159 = 159;
    private static final int METHOD_transferFocusDownCycle160 = 160;
    private static final int METHOD_transferFocusUpCycle161 = 161;
    private static final int METHOD_unregisterKeyboardAction162 = 162;
    private static final int METHOD_update163 = 163;
    private static final int METHOD_updateUI164 = 164;
    private static final int METHOD_validate165 = 165;
    private static final int METHOD_viewToModel166 = 166;
    private static final int METHOD_write167 = 167;

    // Method array 
    /*lazy MethodDescriptor*/
    private static MethodDescriptor[] getMdescriptor(){
        MethodDescriptor[] methods = new MethodDescriptor[168];
    
        try {
            methods[METHOD_action0] = new MethodDescriptor(java.awt.Component.class.getMethod("action", new Class[] {java.awt.Event.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_action0].setDisplayName ( "" );
            methods[METHOD_add1] = new MethodDescriptor(java.awt.Component.class.getMethod("add", new Class[] {java.awt.PopupMenu.class})); // NOI18N
            methods[METHOD_add1].setDisplayName ( "" );
            methods[METHOD_add2] = new MethodDescriptor(java.awt.Container.class.getMethod("add", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_add2].setDisplayName ( "" );
            methods[METHOD_add3] = new MethodDescriptor(java.awt.Container.class.getMethod("add", new Class[] {java.lang.String.class, java.awt.Component.class})); // NOI18N
            methods[METHOD_add3].setDisplayName ( "" );
            methods[METHOD_add4] = new MethodDescriptor(java.awt.Container.class.getMethod("add", new Class[] {java.awt.Component.class, int.class})); // NOI18N
            methods[METHOD_add4].setDisplayName ( "" );
            methods[METHOD_add5] = new MethodDescriptor(java.awt.Container.class.getMethod("add", new Class[] {java.awt.Component.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_add5].setDisplayName ( "" );
            methods[METHOD_add6] = new MethodDescriptor(java.awt.Container.class.getMethod("add", new Class[] {java.awt.Component.class, java.lang.Object.class, int.class})); // NOI18N
            methods[METHOD_add6].setDisplayName ( "" );
            methods[METHOD_addKeymap7] = new MethodDescriptor(javax.swing.text.JTextComponent.class.getMethod("addKeymap", new Class[] {java.lang.String.class, javax.swing.text.Keymap.class})); // NOI18N
            methods[METHOD_addKeymap7].setDisplayName ( "" );
            methods[METHOD_addNotify8] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("addNotify", new Class[] {})); // NOI18N
            methods[METHOD_addNotify8].setDisplayName ( "" );
            methods[METHOD_addPropertyChangeListener9] = new MethodDescriptor(java.awt.Container.class.getMethod("addPropertyChangeListener", new Class[] {java.lang.String.class, java.beans.PropertyChangeListener.class})); // NOI18N
            methods[METHOD_addPropertyChangeListener9].setDisplayName ( "" );
            methods[METHOD_applyComponentOrientation10] = new MethodDescriptor(java.awt.Container.class.getMethod("applyComponentOrientation", new Class[] {java.awt.ComponentOrientation.class})); // NOI18N
            methods[METHOD_applyComponentOrientation10].setDisplayName ( "" );
            methods[METHOD_areFocusTraversalKeysSet11] = new MethodDescriptor(java.awt.Container.class.getMethod("areFocusTraversalKeysSet", new Class[] {int.class})); // NOI18N
            methods[METHOD_areFocusTraversalKeysSet11].setDisplayName ( "" );
            methods[METHOD_bounds12] = new MethodDescriptor(java.awt.Component.class.getMethod("bounds", new Class[] {})); // NOI18N
            methods[METHOD_bounds12].setDisplayName ( "" );
            methods[METHOD_checkImage13] = new MethodDescriptor(java.awt.Component.class.getMethod("checkImage", new Class[] {java.awt.Image.class, java.awt.image.ImageObserver.class})); // NOI18N
            methods[METHOD_checkImage13].setDisplayName ( "" );
            methods[METHOD_checkImage14] = new MethodDescriptor(java.awt.Component.class.getMethod("checkImage", new Class[] {java.awt.Image.class, int.class, int.class, java.awt.image.ImageObserver.class})); // NOI18N
            methods[METHOD_checkImage14].setDisplayName ( "" );
            methods[METHOD_computeVisibleRect15] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("computeVisibleRect", new Class[] {java.awt.Rectangle.class})); // NOI18N
            methods[METHOD_computeVisibleRect15].setDisplayName ( "" );
            methods[METHOD_contains16] = new MethodDescriptor(java.awt.Component.class.getMethod("contains", new Class[] {java.awt.Point.class})); // NOI18N
            methods[METHOD_contains16].setDisplayName ( "" );
            methods[METHOD_contains17] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("contains", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_contains17].setDisplayName ( "" );
            methods[METHOD_copy18] = new MethodDescriptor(javax.swing.text.JTextComponent.class.getMethod("copy", new Class[] {})); // NOI18N
            methods[METHOD_copy18].setDisplayName ( "" );
            methods[METHOD_countComponents19] = new MethodDescriptor(java.awt.Container.class.getMethod("countComponents", new Class[] {})); // NOI18N
            methods[METHOD_countComponents19].setDisplayName ( "" );
            methods[METHOD_createImage20] = new MethodDescriptor(java.awt.Component.class.getMethod("createImage", new Class[] {java.awt.image.ImageProducer.class})); // NOI18N
            methods[METHOD_createImage20].setDisplayName ( "" );
            methods[METHOD_createImage21] = new MethodDescriptor(java.awt.Component.class.getMethod("createImage", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_createImage21].setDisplayName ( "" );
            methods[METHOD_createToolTip22] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("createToolTip", new Class[] {})); // NOI18N
            methods[METHOD_createToolTip22].setDisplayName ( "" );
            methods[METHOD_createVolatileImage23] = new MethodDescriptor(java.awt.Component.class.getMethod("createVolatileImage", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_createVolatileImage23].setDisplayName ( "" );
            methods[METHOD_createVolatileImage24] = new MethodDescriptor(java.awt.Component.class.getMethod("createVolatileImage", new Class[] {int.class, int.class, java.awt.ImageCapabilities.class})); // NOI18N
            methods[METHOD_createVolatileImage24].setDisplayName ( "" );
            methods[METHOD_cut25] = new MethodDescriptor(javax.swing.text.JTextComponent.class.getMethod("cut", new Class[] {})); // NOI18N
            methods[METHOD_cut25].setDisplayName ( "" );
            methods[METHOD_deliverEvent26] = new MethodDescriptor(java.awt.Container.class.getMethod("deliverEvent", new Class[] {java.awt.Event.class})); // NOI18N
            methods[METHOD_deliverEvent26].setDisplayName ( "" );
            methods[METHOD_disable27] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("disable", new Class[] {})); // NOI18N
            methods[METHOD_disable27].setDisplayName ( "" );
            methods[METHOD_dispatchEvent28] = new MethodDescriptor(java.awt.Component.class.getMethod("dispatchEvent", new Class[] {java.awt.AWTEvent.class})); // NOI18N
            methods[METHOD_dispatchEvent28].setDisplayName ( "" );
            methods[METHOD_doLayout29] = new MethodDescriptor(java.awt.Container.class.getMethod("doLayout", new Class[] {})); // NOI18N
            methods[METHOD_doLayout29].setDisplayName ( "" );
            methods[METHOD_enable30] = new MethodDescriptor(java.awt.Component.class.getMethod("enable", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_enable30].setDisplayName ( "" );
            methods[METHOD_enable31] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("enable", new Class[] {})); // NOI18N
            methods[METHOD_enable31].setDisplayName ( "" );
            methods[METHOD_enableInputMethods32] = new MethodDescriptor(java.awt.Component.class.getMethod("enableInputMethods", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_enableInputMethods32].setDisplayName ( "" );
            methods[METHOD_findComponentAt33] = new MethodDescriptor(java.awt.Container.class.getMethod("findComponentAt", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_findComponentAt33].setDisplayName ( "" );
            methods[METHOD_findComponentAt34] = new MethodDescriptor(java.awt.Container.class.getMethod("findComponentAt", new Class[] {java.awt.Point.class})); // NOI18N
            methods[METHOD_findComponentAt34].setDisplayName ( "" );
            methods[METHOD_firePropertyChange35] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, byte.class, byte.class})); // NOI18N
            methods[METHOD_firePropertyChange35].setDisplayName ( "" );
            methods[METHOD_firePropertyChange36] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, short.class, short.class})); // NOI18N
            methods[METHOD_firePropertyChange36].setDisplayName ( "" );
            methods[METHOD_firePropertyChange37] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, long.class, long.class})); // NOI18N
            methods[METHOD_firePropertyChange37].setDisplayName ( "" );
            methods[METHOD_firePropertyChange38] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, float.class, float.class})); // NOI18N
            methods[METHOD_firePropertyChange38].setDisplayName ( "" );
            methods[METHOD_firePropertyChange39] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, double.class, double.class})); // NOI18N
            methods[METHOD_firePropertyChange39].setDisplayName ( "" );
            methods[METHOD_firePropertyChange40] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, boolean.class, boolean.class})); // NOI18N
            methods[METHOD_firePropertyChange40].setDisplayName ( "" );
            methods[METHOD_firePropertyChange41] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, int.class, int.class})); // NOI18N
            methods[METHOD_firePropertyChange41].setDisplayName ( "" );
            methods[METHOD_firePropertyChange42] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, char.class, char.class})); // NOI18N
            methods[METHOD_firePropertyChange42].setDisplayName ( "" );
            methods[METHOD_focusGained43] = new MethodDescriptor(client.utils.HintTextField.class.getMethod("focusGained", new Class[] {java.awt.event.FocusEvent.class})); // NOI18N
            methods[METHOD_focusGained43].setDisplayName ( "" );
            methods[METHOD_focusLost44] = new MethodDescriptor(client.utils.HintTextField.class.getMethod("focusLost", new Class[] {java.awt.event.FocusEvent.class})); // NOI18N
            methods[METHOD_focusLost44].setDisplayName ( "" );
            methods[METHOD_getActionForKeyStroke45] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getActionForKeyStroke", new Class[] {javax.swing.KeyStroke.class})); // NOI18N
            methods[METHOD_getActionForKeyStroke45].setDisplayName ( "" );
            methods[METHOD_getBaseline46] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getBaseline", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_getBaseline46].setDisplayName ( "" );
            methods[METHOD_getBounds47] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getBounds", new Class[] {java.awt.Rectangle.class})); // NOI18N
            methods[METHOD_getBounds47].setDisplayName ( "" );
            methods[METHOD_getClientProperty48] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getClientProperty", new Class[] {java.lang.Object.class})); // NOI18N
            methods[METHOD_getClientProperty48].setDisplayName ( "" );
            methods[METHOD_getComponentAt49] = new MethodDescriptor(java.awt.Container.class.getMethod("getComponentAt", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_getComponentAt49].setDisplayName ( "" );
            methods[METHOD_getComponentAt50] = new MethodDescriptor(java.awt.Container.class.getMethod("getComponentAt", new Class[] {java.awt.Point.class})); // NOI18N
            methods[METHOD_getComponentAt50].setDisplayName ( "" );
            methods[METHOD_getComponentZOrder51] = new MethodDescriptor(java.awt.Container.class.getMethod("getComponentZOrder", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_getComponentZOrder51].setDisplayName ( "" );
            methods[METHOD_getConditionForKeyStroke52] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getConditionForKeyStroke", new Class[] {javax.swing.KeyStroke.class})); // NOI18N
            methods[METHOD_getConditionForKeyStroke52].setDisplayName ( "" );
            methods[METHOD_getDefaultLocale53] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getDefaultLocale", new Class[] {})); // NOI18N
            methods[METHOD_getDefaultLocale53].setDisplayName ( "" );
            methods[METHOD_getFocusTraversalKeys54] = new MethodDescriptor(java.awt.Container.class.getMethod("getFocusTraversalKeys", new Class[] {int.class})); // NOI18N
            methods[METHOD_getFocusTraversalKeys54].setDisplayName ( "" );
            methods[METHOD_getFontMetrics55] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getFontMetrics", new Class[] {java.awt.Font.class})); // NOI18N
            methods[METHOD_getFontMetrics55].setDisplayName ( "" );
            methods[METHOD_getInsets56] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getInsets", new Class[] {java.awt.Insets.class})); // NOI18N
            methods[METHOD_getInsets56].setDisplayName ( "" );
            methods[METHOD_getKeymap57] = new MethodDescriptor(javax.swing.text.JTextComponent.class.getMethod("getKeymap", new Class[] {java.lang.String.class})); // NOI18N
            methods[METHOD_getKeymap57].setDisplayName ( "" );
            methods[METHOD_getListeners58] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getListeners", new Class[] {java.lang.Class.class})); // NOI18N
            methods[METHOD_getListeners58].setDisplayName ( "" );
            methods[METHOD_getLocation59] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getLocation", new Class[] {java.awt.Point.class})); // NOI18N
            methods[METHOD_getLocation59].setDisplayName ( "" );
            methods[METHOD_getMousePosition60] = new MethodDescriptor(java.awt.Container.class.getMethod("getMousePosition", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_getMousePosition60].setDisplayName ( "" );
            methods[METHOD_getPopupLocation61] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getPopupLocation", new Class[] {java.awt.event.MouseEvent.class})); // NOI18N
            methods[METHOD_getPopupLocation61].setDisplayName ( "" );
            methods[METHOD_getPrintable62] = new MethodDescriptor(javax.swing.text.JTextComponent.class.getMethod("getPrintable", new Class[] {java.text.MessageFormat.class, java.text.MessageFormat.class})); // NOI18N
            methods[METHOD_getPrintable62].setDisplayName ( "" );
            methods[METHOD_getPropertyChangeListeners63] = new MethodDescriptor(java.awt.Component.class.getMethod("getPropertyChangeListeners", new Class[] {java.lang.String.class})); // NOI18N
            methods[METHOD_getPropertyChangeListeners63].setDisplayName ( "" );
            methods[METHOD_getScrollableBlockIncrement64] = new MethodDescriptor(javax.swing.text.JTextComponent.class.getMethod("getScrollableBlockIncrement", new Class[] {java.awt.Rectangle.class, int.class, int.class})); // NOI18N
            methods[METHOD_getScrollableBlockIncrement64].setDisplayName ( "" );
            methods[METHOD_getScrollableUnitIncrement65] = new MethodDescriptor(javax.swing.text.JTextComponent.class.getMethod("getScrollableUnitIncrement", new Class[] {java.awt.Rectangle.class, int.class, int.class})); // NOI18N
            methods[METHOD_getScrollableUnitIncrement65].setDisplayName ( "" );
            methods[METHOD_getSize66] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getSize", new Class[] {java.awt.Dimension.class})); // NOI18N
            methods[METHOD_getSize66].setDisplayName ( "" );
            methods[METHOD_getText67] = new MethodDescriptor(javax.swing.text.JTextComponent.class.getMethod("getText", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_getText67].setDisplayName ( "" );
            methods[METHOD_getToolTipLocation68] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getToolTipLocation", new Class[] {java.awt.event.MouseEvent.class})); // NOI18N
            methods[METHOD_getToolTipLocation68].setDisplayName ( "" );
            methods[METHOD_getToolTipText69] = new MethodDescriptor(javax.swing.text.JTextComponent.class.getMethod("getToolTipText", new Class[] {java.awt.event.MouseEvent.class})); // NOI18N
            methods[METHOD_getToolTipText69].setDisplayName ( "" );
            methods[METHOD_gotFocus70] = new MethodDescriptor(java.awt.Component.class.getMethod("gotFocus", new Class[] {java.awt.Event.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_gotFocus70].setDisplayName ( "" );
            methods[METHOD_grabFocus71] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("grabFocus", new Class[] {})); // NOI18N
            methods[METHOD_grabFocus71].setDisplayName ( "" );
            methods[METHOD_handleEvent72] = new MethodDescriptor(java.awt.Component.class.getMethod("handleEvent", new Class[] {java.awt.Event.class})); // NOI18N
            methods[METHOD_handleEvent72].setDisplayName ( "" );
            methods[METHOD_hasFocus73] = new MethodDescriptor(java.awt.Component.class.getMethod("hasFocus", new Class[] {})); // NOI18N
            methods[METHOD_hasFocus73].setDisplayName ( "" );
            methods[METHOD_hide74] = new MethodDescriptor(java.awt.Component.class.getMethod("hide", new Class[] {})); // NOI18N
            methods[METHOD_hide74].setDisplayName ( "" );
            methods[METHOD_imageUpdate75] = new MethodDescriptor(java.awt.Component.class.getMethod("imageUpdate", new Class[] {java.awt.Image.class, int.class, int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_imageUpdate75].setDisplayName ( "" );
            methods[METHOD_insets76] = new MethodDescriptor(java.awt.Container.class.getMethod("insets", new Class[] {})); // NOI18N
            methods[METHOD_insets76].setDisplayName ( "" );
            methods[METHOD_inside77] = new MethodDescriptor(java.awt.Component.class.getMethod("inside", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_inside77].setDisplayName ( "" );
            methods[METHOD_invalidate78] = new MethodDescriptor(java.awt.Container.class.getMethod("invalidate", new Class[] {})); // NOI18N
            methods[METHOD_invalidate78].setDisplayName ( "" );
            methods[METHOD_isAncestorOf79] = new MethodDescriptor(java.awt.Container.class.getMethod("isAncestorOf", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_isAncestorOf79].setDisplayName ( "" );
            methods[METHOD_isFocusCycleRoot80] = new MethodDescriptor(java.awt.Container.class.getMethod("isFocusCycleRoot", new Class[] {java.awt.Container.class})); // NOI18N
            methods[METHOD_isFocusCycleRoot80].setDisplayName ( "" );
            methods[METHOD_isLightweightComponent81] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("isLightweightComponent", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_isLightweightComponent81].setDisplayName ( "" );
            methods[METHOD_keyDown82] = new MethodDescriptor(java.awt.Component.class.getMethod("keyDown", new Class[] {java.awt.Event.class, int.class})); // NOI18N
            methods[METHOD_keyDown82].setDisplayName ( "" );
            methods[METHOD_keyUp83] = new MethodDescriptor(java.awt.Component.class.getMethod("keyUp", new Class[] {java.awt.Event.class, int.class})); // NOI18N
            methods[METHOD_keyUp83].setDisplayName ( "" );
            methods[METHOD_layout84] = new MethodDescriptor(java.awt.Container.class.getMethod("layout", new Class[] {})); // NOI18N
            methods[METHOD_layout84].setDisplayName ( "" );
            methods[METHOD_list85] = new MethodDescriptor(java.awt.Component.class.getMethod("list", new Class[] {})); // NOI18N
            methods[METHOD_list85].setDisplayName ( "" );
            methods[METHOD_list86] = new MethodDescriptor(java.awt.Component.class.getMethod("list", new Class[] {java.io.PrintStream.class})); // NOI18N
            methods[METHOD_list86].setDisplayName ( "" );
            methods[METHOD_list87] = new MethodDescriptor(java.awt.Component.class.getMethod("list", new Class[] {java.io.PrintWriter.class})); // NOI18N
            methods[METHOD_list87].setDisplayName ( "" );
            methods[METHOD_list88] = new MethodDescriptor(java.awt.Container.class.getMethod("list", new Class[] {java.io.PrintStream.class, int.class})); // NOI18N
            methods[METHOD_list88].setDisplayName ( "" );
            methods[METHOD_list89] = new MethodDescriptor(java.awt.Container.class.getMethod("list", new Class[] {java.io.PrintWriter.class, int.class})); // NOI18N
            methods[METHOD_list89].setDisplayName ( "" );
            methods[METHOD_loadKeymap90] = new MethodDescriptor(javax.swing.text.JTextComponent.class.getMethod("loadKeymap", new Class[] {javax.swing.text.Keymap.class, javax.swing.text.JTextComponent.KeyBinding[].class, javax.swing.Action[].class})); // NOI18N
            methods[METHOD_loadKeymap90].setDisplayName ( "" );
            methods[METHOD_locate91] = new MethodDescriptor(java.awt.Container.class.getMethod("locate", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_locate91].setDisplayName ( "" );
            methods[METHOD_location92] = new MethodDescriptor(java.awt.Component.class.getMethod("location", new Class[] {})); // NOI18N
            methods[METHOD_location92].setDisplayName ( "" );
            methods[METHOD_lostFocus93] = new MethodDescriptor(java.awt.Component.class.getMethod("lostFocus", new Class[] {java.awt.Event.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_lostFocus93].setDisplayName ( "" );
            methods[METHOD_minimumSize94] = new MethodDescriptor(java.awt.Container.class.getMethod("minimumSize", new Class[] {})); // NOI18N
            methods[METHOD_minimumSize94].setDisplayName ( "" );
            methods[METHOD_modelToView95] = new MethodDescriptor(javax.swing.text.JTextComponent.class.getMethod("modelToView", new Class[] {int.class})); // NOI18N
            methods[METHOD_modelToView95].setDisplayName ( "" );
            methods[METHOD_mouseDown96] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseDown", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseDown96].setDisplayName ( "" );
            methods[METHOD_mouseDrag97] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseDrag", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseDrag97].setDisplayName ( "" );
            methods[METHOD_mouseEnter98] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseEnter", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseEnter98].setDisplayName ( "" );
            methods[METHOD_mouseExit99] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseExit", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseExit99].setDisplayName ( "" );
            methods[METHOD_mouseMove100] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseMove", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseMove100].setDisplayName ( "" );
            methods[METHOD_mouseUp101] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseUp", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseUp101].setDisplayName ( "" );
            methods[METHOD_move102] = new MethodDescriptor(java.awt.Component.class.getMethod("move", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_move102].setDisplayName ( "" );
            methods[METHOD_moveCaretPosition103] = new MethodDescriptor(javax.swing.text.JTextComponent.class.getMethod("moveCaretPosition", new Class[] {int.class})); // NOI18N
            methods[METHOD_moveCaretPosition103].setDisplayName ( "" );
            methods[METHOD_nextFocus104] = new MethodDescriptor(java.awt.Component.class.getMethod("nextFocus", new Class[] {})); // NOI18N
            methods[METHOD_nextFocus104].setDisplayName ( "" );
            methods[METHOD_paint105] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("paint", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_paint105].setDisplayName ( "" );
            methods[METHOD_paintAll106] = new MethodDescriptor(java.awt.Component.class.getMethod("paintAll", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_paintAll106].setDisplayName ( "" );
            methods[METHOD_paintComponents107] = new MethodDescriptor(java.awt.Container.class.getMethod("paintComponents", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_paintComponents107].setDisplayName ( "" );
            methods[METHOD_paintImmediately108] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("paintImmediately", new Class[] {int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_paintImmediately108].setDisplayName ( "" );
            methods[METHOD_paintImmediately109] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("paintImmediately", new Class[] {java.awt.Rectangle.class})); // NOI18N
            methods[METHOD_paintImmediately109].setDisplayName ( "" );
            methods[METHOD_paste110] = new MethodDescriptor(javax.swing.text.JTextComponent.class.getMethod("paste", new Class[] {})); // NOI18N
            methods[METHOD_paste110].setDisplayName ( "" );
            methods[METHOD_postActionEvent111] = new MethodDescriptor(javax.swing.JTextField.class.getMethod("postActionEvent", new Class[] {})); // NOI18N
            methods[METHOD_postActionEvent111].setDisplayName ( "" );
            methods[METHOD_postEvent112] = new MethodDescriptor(java.awt.Component.class.getMethod("postEvent", new Class[] {java.awt.Event.class})); // NOI18N
            methods[METHOD_postEvent112].setDisplayName ( "" );
            methods[METHOD_preferredSize113] = new MethodDescriptor(java.awt.Container.class.getMethod("preferredSize", new Class[] {})); // NOI18N
            methods[METHOD_preferredSize113].setDisplayName ( "" );
            methods[METHOD_prepareImage114] = new MethodDescriptor(java.awt.Component.class.getMethod("prepareImage", new Class[] {java.awt.Image.class, java.awt.image.ImageObserver.class})); // NOI18N
            methods[METHOD_prepareImage114].setDisplayName ( "" );
            methods[METHOD_prepareImage115] = new MethodDescriptor(java.awt.Component.class.getMethod("prepareImage", new Class[] {java.awt.Image.class, int.class, int.class, java.awt.image.ImageObserver.class})); // NOI18N
            methods[METHOD_prepareImage115].setDisplayName ( "" );
            methods[METHOD_print116] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("print", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_print116].setDisplayName ( "" );
            methods[METHOD_print117] = new MethodDescriptor(javax.swing.text.JTextComponent.class.getMethod("print", new Class[] {})); // NOI18N
            methods[METHOD_print117].setDisplayName ( "" );
            methods[METHOD_print118] = new MethodDescriptor(javax.swing.text.JTextComponent.class.getMethod("print", new Class[] {java.text.MessageFormat.class, java.text.MessageFormat.class})); // NOI18N
            methods[METHOD_print118].setDisplayName ( "" );
            methods[METHOD_print119] = new MethodDescriptor(javax.swing.text.JTextComponent.class.getMethod("print", new Class[] {java.text.MessageFormat.class, java.text.MessageFormat.class, boolean.class, javax.print.PrintService.class, javax.print.attribute.PrintRequestAttributeSet.class, boolean.class})); // NOI18N
            methods[METHOD_print119].setDisplayName ( "" );
            methods[METHOD_printAll120] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("printAll", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_printAll120].setDisplayName ( "" );
            methods[METHOD_printComponents121] = new MethodDescriptor(java.awt.Container.class.getMethod("printComponents", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_printComponents121].setDisplayName ( "" );
            methods[METHOD_putClientProperty122] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("putClientProperty", new Class[] {java.lang.Object.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_putClientProperty122].setDisplayName ( "" );
            methods[METHOD_read123] = new MethodDescriptor(javax.swing.text.JTextComponent.class.getMethod("read", new Class[] {java.io.Reader.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_read123].setDisplayName ( "" );
            methods[METHOD_registerKeyboardAction124] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("registerKeyboardAction", new Class[] {java.awt.event.ActionListener.class, java.lang.String.class, javax.swing.KeyStroke.class, int.class})); // NOI18N
            methods[METHOD_registerKeyboardAction124].setDisplayName ( "" );
            methods[METHOD_registerKeyboardAction125] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("registerKeyboardAction", new Class[] {java.awt.event.ActionListener.class, javax.swing.KeyStroke.class, int.class})); // NOI18N
            methods[METHOD_registerKeyboardAction125].setDisplayName ( "" );
            methods[METHOD_remove126] = new MethodDescriptor(java.awt.Component.class.getMethod("remove", new Class[] {java.awt.MenuComponent.class})); // NOI18N
            methods[METHOD_remove126].setDisplayName ( "" );
            methods[METHOD_remove127] = new MethodDescriptor(java.awt.Container.class.getMethod("remove", new Class[] {int.class})); // NOI18N
            methods[METHOD_remove127].setDisplayName ( "" );
            methods[METHOD_remove128] = new MethodDescriptor(java.awt.Container.class.getMethod("remove", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_remove128].setDisplayName ( "" );
            methods[METHOD_removeAll129] = new MethodDescriptor(java.awt.Container.class.getMethod("removeAll", new Class[] {})); // NOI18N
            methods[METHOD_removeAll129].setDisplayName ( "" );
            methods[METHOD_removeKeymap130] = new MethodDescriptor(javax.swing.text.JTextComponent.class.getMethod("removeKeymap", new Class[] {java.lang.String.class})); // NOI18N
            methods[METHOD_removeKeymap130].setDisplayName ( "" );
            methods[METHOD_removeNotify131] = new MethodDescriptor(javax.swing.text.JTextComponent.class.getMethod("removeNotify", new Class[] {})); // NOI18N
            methods[METHOD_removeNotify131].setDisplayName ( "" );
            methods[METHOD_removePropertyChangeListener132] = new MethodDescriptor(java.awt.Component.class.getMethod("removePropertyChangeListener", new Class[] {java.lang.String.class, java.beans.PropertyChangeListener.class})); // NOI18N
            methods[METHOD_removePropertyChangeListener132].setDisplayName ( "" );
            methods[METHOD_repaint133] = new MethodDescriptor(java.awt.Component.class.getMethod("repaint", new Class[] {})); // NOI18N
            methods[METHOD_repaint133].setDisplayName ( "" );
            methods[METHOD_repaint134] = new MethodDescriptor(java.awt.Component.class.getMethod("repaint", new Class[] {long.class})); // NOI18N
            methods[METHOD_repaint134].setDisplayName ( "" );
            methods[METHOD_repaint135] = new MethodDescriptor(java.awt.Component.class.getMethod("repaint", new Class[] {int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_repaint135].setDisplayName ( "" );
            methods[METHOD_repaint136] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("repaint", new Class[] {long.class, int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_repaint136].setDisplayName ( "" );
            methods[METHOD_repaint137] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("repaint", new Class[] {java.awt.Rectangle.class})); // NOI18N
            methods[METHOD_repaint137].setDisplayName ( "" );
            methods[METHOD_replaceSelection138] = new MethodDescriptor(javax.swing.text.JTextComponent.class.getMethod("replaceSelection", new Class[] {java.lang.String.class})); // NOI18N
            methods[METHOD_replaceSelection138].setDisplayName ( "" );
            methods[METHOD_requestDefaultFocus139] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("requestDefaultFocus", new Class[] {})); // NOI18N
            methods[METHOD_requestDefaultFocus139].setDisplayName ( "" );
            methods[METHOD_requestFocus140] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("requestFocus", new Class[] {})); // NOI18N
            methods[METHOD_requestFocus140].setDisplayName ( "" );
            methods[METHOD_requestFocus141] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("requestFocus", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_requestFocus141].setDisplayName ( "" );
            methods[METHOD_requestFocusInWindow142] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("requestFocusInWindow", new Class[] {})); // NOI18N
            methods[METHOD_requestFocusInWindow142].setDisplayName ( "" );
            methods[METHOD_resetKeyboardActions143] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("resetKeyboardActions", new Class[] {})); // NOI18N
            methods[METHOD_resetKeyboardActions143].setDisplayName ( "" );
            methods[METHOD_reshape144] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("reshape", new Class[] {int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_reshape144].setDisplayName ( "" );
            methods[METHOD_resize145] = new MethodDescriptor(java.awt.Component.class.getMethod("resize", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_resize145].setDisplayName ( "" );
            methods[METHOD_resize146] = new MethodDescriptor(java.awt.Component.class.getMethod("resize", new Class[] {java.awt.Dimension.class})); // NOI18N
            methods[METHOD_resize146].setDisplayName ( "" );
            methods[METHOD_revalidate147] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("revalidate", new Class[] {})); // NOI18N
            methods[METHOD_revalidate147].setDisplayName ( "" );
            methods[METHOD_scrollRectToVisible148] = new MethodDescriptor(javax.swing.JTextField.class.getMethod("scrollRectToVisible", new Class[] {java.awt.Rectangle.class})); // NOI18N
            methods[METHOD_scrollRectToVisible148].setDisplayName ( "" );
            methods[METHOD_select149] = new MethodDescriptor(javax.swing.text.JTextComponent.class.getMethod("select", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_select149].setDisplayName ( "" );
            methods[METHOD_selectAll150] = new MethodDescriptor(javax.swing.text.JTextComponent.class.getMethod("selectAll", new Class[] {})); // NOI18N
            methods[METHOD_selectAll150].setDisplayName ( "" );
            methods[METHOD_setBounds151] = new MethodDescriptor(java.awt.Component.class.getMethod("setBounds", new Class[] {int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_setBounds151].setDisplayName ( "" );
            methods[METHOD_setComponentZOrder152] = new MethodDescriptor(java.awt.Container.class.getMethod("setComponentZOrder", new Class[] {java.awt.Component.class, int.class})); // NOI18N
            methods[METHOD_setComponentZOrder152].setDisplayName ( "" );
            methods[METHOD_setDefaultLocale153] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("setDefaultLocale", new Class[] {java.util.Locale.class})); // NOI18N
            methods[METHOD_setDefaultLocale153].setDisplayName ( "" );
            methods[METHOD_show154] = new MethodDescriptor(java.awt.Component.class.getMethod("show", new Class[] {})); // NOI18N
            methods[METHOD_show154].setDisplayName ( "" );
            methods[METHOD_show155] = new MethodDescriptor(java.awt.Component.class.getMethod("show", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_show155].setDisplayName ( "" );
            methods[METHOD_size156] = new MethodDescriptor(java.awt.Component.class.getMethod("size", new Class[] {})); // NOI18N
            methods[METHOD_size156].setDisplayName ( "" );
            methods[METHOD_toString157] = new MethodDescriptor(java.awt.Component.class.getMethod("toString", new Class[] {})); // NOI18N
            methods[METHOD_toString157].setDisplayName ( "" );
            methods[METHOD_transferFocus158] = new MethodDescriptor(java.awt.Component.class.getMethod("transferFocus", new Class[] {})); // NOI18N
            methods[METHOD_transferFocus158].setDisplayName ( "" );
            methods[METHOD_transferFocusBackward159] = new MethodDescriptor(java.awt.Container.class.getMethod("transferFocusBackward", new Class[] {})); // NOI18N
            methods[METHOD_transferFocusBackward159].setDisplayName ( "" );
            methods[METHOD_transferFocusDownCycle160] = new MethodDescriptor(java.awt.Container.class.getMethod("transferFocusDownCycle", new Class[] {})); // NOI18N
            methods[METHOD_transferFocusDownCycle160].setDisplayName ( "" );
            methods[METHOD_transferFocusUpCycle161] = new MethodDescriptor(java.awt.Component.class.getMethod("transferFocusUpCycle", new Class[] {})); // NOI18N
            methods[METHOD_transferFocusUpCycle161].setDisplayName ( "" );
            methods[METHOD_unregisterKeyboardAction162] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("unregisterKeyboardAction", new Class[] {javax.swing.KeyStroke.class})); // NOI18N
            methods[METHOD_unregisterKeyboardAction162].setDisplayName ( "" );
            methods[METHOD_update163] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("update", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_update163].setDisplayName ( "" );
            methods[METHOD_updateUI164] = new MethodDescriptor(javax.swing.text.JTextComponent.class.getMethod("updateUI", new Class[] {})); // NOI18N
            methods[METHOD_updateUI164].setDisplayName ( "" );
            methods[METHOD_validate165] = new MethodDescriptor(java.awt.Container.class.getMethod("validate", new Class[] {})); // NOI18N
            methods[METHOD_validate165].setDisplayName ( "" );
            methods[METHOD_viewToModel166] = new MethodDescriptor(javax.swing.text.JTextComponent.class.getMethod("viewToModel", new Class[] {java.awt.Point.class})); // NOI18N
            methods[METHOD_viewToModel166].setDisplayName ( "" );
            methods[METHOD_write167] = new MethodDescriptor(javax.swing.text.JTextComponent.class.getMethod("write", new Class[] {java.io.Writer.class})); // NOI18N
            methods[METHOD_write167].setDisplayName ( "" );
        }
        catch( Exception e) {}//GEN-HEADEREND:Methods

        // Here you can add code for customizing the methods array.
        
        return methods;     }//GEN-LAST:Methods
    private static java.awt.Image iconColor16 = null;//GEN-BEGIN:IconsDef
    private static java.awt.Image iconColor32 = null;
    private static java.awt.Image iconMono16 = null;
    private static java.awt.Image iconMono32 = null;//GEN-END:IconsDef
    private static String iconNameC16 = null;//GEN-BEGIN:Icons
    private static String iconNameC32 = null;
    private static String iconNameM16 = null;
    private static String iconNameM32 = null;//GEN-END:Icons
    private static final int defaultPropertyIndex = -1;//GEN-BEGIN:Idx
    private static final int defaultEventIndex = -1;//GEN-END:Idx

//GEN-FIRST:Superclass
    // Here you can add code for customizing the Superclass BeanInfo.
//GEN-LAST:Superclass
    /**
     * Gets the bean's
     * <code>BeanDescriptor</code>s.
     *
     * @return BeanDescriptor describing the editable properties of this bean.
     * May return null if the information should be obtained by automatic
     * analysis.
     */
    @Override
    public BeanDescriptor getBeanDescriptor() {
        return getBdescriptor();
    }

    /**
     * Gets the bean's
     * <code>PropertyDescriptor</code>s.
     *
     * @return An array of PropertyDescriptors describing the editable
     * properties supported by this bean. May return null if the information
     * should be obtained by automatic analysis. <p> If a property is indexed,
     * then its entry in the result array will belong to the
     * IndexedPropertyDescriptor subclass of PropertyDescriptor. A client of
     * getPropertyDescriptors can use "instanceof" to check if a given
     * PropertyDescriptor is an IndexedPropertyDescriptor.
     */
    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        return getPdescriptor();
    }

    /**
     * Gets the bean's
     * <code>EventSetDescriptor</code>s.
     *
     * @return An array of EventSetDescriptors describing the kinds of events
     * fired by this bean. May return null if the information should be obtained
     * by automatic analysis.
     */
    @Override
    public EventSetDescriptor[] getEventSetDescriptors() {
        return getEdescriptor();
    }

    /**
     * Gets the bean's
     * <code>MethodDescriptor</code>s.
     *
     * @return An array of MethodDescriptors describing the methods implemented
     * by this bean. May return null if the information should be obtained by
     * automatic analysis.
     */
    @Override
    public MethodDescriptor[] getMethodDescriptors() {
        return getMdescriptor();
    }

    /**
     * A bean may have a "default" property that is the property that will
     * mostly commonly be initially chosen for update by human's who are
     * customizing the bean.
     *
     * @return Index of default property in the PropertyDescriptor array
     * returned by getPropertyDescriptors. <P>	Returns -1 if there is no default
     * property.
     */
    @Override
    public int getDefaultPropertyIndex() {
        return defaultPropertyIndex;
    }

    /**
     * A bean may have a "default" event that is the event that will mostly
     * commonly be used by human's when using the bean.
     *
     * @return Index of default event in the EventSetDescriptor array returned
     * by getEventSetDescriptors. <P>	Returns -1 if there is no default event.
     */
    @Override
    public int getDefaultEventIndex() {
        return defaultEventIndex;
    }

    /**
     * This method returns an image object that can be used to represent the
     * bean in toolboxes, toolbars, etc. Icon images will typically be GIFs, but
     * may in future include other formats. <p> Beans aren't required to provide
     * icons and may return null from this method. <p> There are four possible
     * flavors of icons (16x16 color, 32x32 color, 16x16 mono, 32x32 mono). If a
     * bean choses to only support a single icon we recommend supporting 16x16
     * color. <p> We recommend that icons have a "transparent" background so
     * they can be rendered onto an existing background.
     *
     * @param iconKind The kind of icon requested. This should be one of the
     * constant values ICON_COLOR_16x16, ICON_COLOR_32x32, ICON_MONO_16x16, or
     * ICON_MONO_32x32.
     * @return An image object representing the requested icon. May return null
     * if no suitable icon is available.
     */
    @Override
    public java.awt.Image getIcon(int iconKind) {
        switch (iconKind) {
            case ICON_COLOR_16x16:
                if (iconNameC16 == null) {
                    return null;
                } else {
                    if (iconColor16 == null) {
                        iconColor16 = loadImage(iconNameC16);
                    }
                    return iconColor16;
                }
            case ICON_COLOR_32x32:
                if (iconNameC32 == null) {
                    return null;
                } else {
                    if (iconColor32 == null) {
                        iconColor32 = loadImage(iconNameC32);
                    }
                    return iconColor32;
                }
            case ICON_MONO_16x16:
                if (iconNameM16 == null) {
                    return null;
                } else {
                    if (iconMono16 == null) {
                        iconMono16 = loadImage(iconNameM16);
                    }
                    return iconMono16;
                }
            case ICON_MONO_32x32:
                if (iconNameM32 == null) {
                    return null;
                } else {
                    if (iconMono32 == null) {
                        iconMono32 = loadImage(iconNameM32);
                    }
                    return iconMono32;
                }
            default:
                return null;
        }
    }
}
