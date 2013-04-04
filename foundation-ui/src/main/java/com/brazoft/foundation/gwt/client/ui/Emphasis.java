/**
 * Copyright (C) 2009-2012 the original author or authors.
 * See the notice.md file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.brazoft.foundation.gwt.client.ui;

import com.brazoft.foundation.gwt.client.component.ElementResolver;
import com.brazoft.foundation.gwt.client.component.api.Component;
import com.brazoft.foundation.gwt.client.component.api.HasText;
import com.brazoft.foundation.gwt.client.ui.api.Bootstrap;
import com.google.gwt.dom.client.Element;

public class Emphasis extends Bootstrap<Emphasis> implements HasText<Emphasis>
{
	public Emphasis(EmphasisOptions option)
	{
		super(option.resolveElement());
	}
	
	public Emphasis warning()
	{
		return this.className("text-warning");
	}
	
	public Emphasis error()
	{
		return this.className("text-error");
	}
	
	public Emphasis info()
	{
		return this.className("text-info");
	}
	
	public Emphasis success()
	{
		return this.className("text-success");
	}
	
	@Override
	public String getText()
	{
		return Component.Util.getHTML(this);
	}
	
	@Override
	public Emphasis text(String text)
	{
		return Component.Util.setHTML(this, text);
	}

	public enum EmphasisOptions
	{
		SMALL, BOLD, ITALIC;

		Element resolveElement()
		{
			switch (this)
			{
				case SMALL:
					return ElementResolver.small();
				case BOLD:
					return ElementResolver.strong();
				case ITALIC:
					return ElementResolver.em();
			}
			
			return null;
		}
	}
}