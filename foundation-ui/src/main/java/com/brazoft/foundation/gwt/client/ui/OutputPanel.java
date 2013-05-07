package com.brazoft.foundation.gwt.client.ui;

import com.brazoft.foundation.gwt.client.ui.api.AbstractTable.Row.Cell;
import com.brazoft.foundation.gwt.client.ui.api.DataPanel;
import com.google.gwt.user.client.ui.Widget;

@SuppressWarnings("unchecked")
public abstract class OutputPanel<O extends OutputPanel<O>> extends DataPanel<O>
{
	public OutputPanel(int columns)
	{
		super(columns);
	}
	
	public O item(String label, String value)
	{
		return this.item(label, value, 1);
	}
	
	public O item(String label, String value, int colspan)
	{
		if(value == null)
		{
			value = "&nbsp;";
		}
		
		Paragraph p = new Paragraph().text(value);
		return this.item(label, p, colspan);
	}
	
	public O item(String label, Widget value)
	{
		return this.item(label, value, 1);
	}
	
	public O item(String label, Widget value, int colspan)
	{
		OutputGroup group = new OutputGroup(value).label(label).colspan(colspan);
		
		Cell cell = this.cell(group.getColspan());
		cell.add(group.getLabel());
		cell.add(group);
		
		return (O) this;
	}
}