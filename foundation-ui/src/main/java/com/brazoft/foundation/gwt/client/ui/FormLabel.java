package com.brazoft.foundation.gwt.client.ui;

import com.brazoft.foundation.gwt.client.component.ElementResolver;
import com.brazoft.foundation.gwt.client.component.api.Component;
import com.brazoft.foundation.gwt.client.component.api.HasText;
import com.brazoft.foundation.gwt.client.component.api.UIInput;
import com.brazoft.foundation.gwt.client.ui.Emphasis.EmphasisOptions;
import com.google.gwt.dom.client.LabelElement;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;

public class FormLabel extends Component<FormLabel> implements HasText<FormLabel>
{
	private Emphasis text;
	
	public FormLabel()
	{
		super(ElementResolver.label());
	}
	
	public FormLabel forInput(UIInput<?, ?> input)
	{
		this.forId(input.getId());
		
		if(input instanceof CheckBox || input instanceof RadioButton)
		{
			this.add(input.asWidget());
			input.style().display(Display.INLINE).paddingLeft(4, Unit.PX);
			this.text = new Emphasis(EmphasisOptions.SMALL).muted();
			this.text.style().display(Display.INLINE).paddingLeft(4, Unit.PX);
			this.add(this.text);
			
			return this;
		}
		
		return this.add(input.asWidget());
	}
	
	public FormLabel forId(String id)
	{
		this.element().setHtmlFor(id);
		return this;
	}

	@Override
	public FormLabel text(String text)
	{
		if(this.text == null)
		{
			this.text = new Emphasis(EmphasisOptions.SMALL).muted();
			this.add(this.text);
		}
		this.text.text(text);
		
		return this;
	}

	@Override
	public String getText()
	{
		if(this.text != null)
		{
			return this.text.getText();
		}
		
		return "";
	}
	
	protected LabelElement element()
	{
		return this.getElement().cast();
	}
}