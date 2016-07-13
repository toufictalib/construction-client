package client.gui.combobox;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.matchers.TextMatcherEditor;
import ca.odell.glazedlists.swing.AutoCompleteSupport;

public class ComboboxUtils
{
	@SuppressWarnings("rawtypes")
	public static AutoCompleteSupport fillComboboxes(AutoCompleteSupport support, JComboBox combobox, ArrayList<?> a)
	{
		if (support != null && support.isInstalled())
		{
			support.uninstall();
		}
		support = AutoCompleteSupport.install(combobox, GlazedLists.eventList(a));
		support.setFilterMode(TextMatcherEditor.CONTAINS);
		return support;
	}

	public static AutoCompleteSupport<?> installAutoCompleteSupport(@SuppressWarnings("rawtypes") JComboBox combobox, List<?> a)
	{
		AutoCompleteSupport<?> support = null;
		support = AutoCompleteSupport.install(combobox, GlazedLists.eventList(a));
		support.setFilterMode(TextMatcherEditor.CONTAINS);
		return support;
	}
}
