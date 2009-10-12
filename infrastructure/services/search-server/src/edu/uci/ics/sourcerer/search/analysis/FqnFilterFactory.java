/*
 * Sourcerer: An infrastructure for large-scale source code analysis.
 * Copyright (C) by contributors. See CONTRIBUTORS.txt for full list.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package edu.uci.ics.sourcerer.search.analysis;

import java.util.Map;

import org.apache.solr.analysis.BaseTokenFilterFactory;
import org.apache.lucene.analysis.TokenStream;

/**
 * 
 * @author <a href="bajracharya@gmail.com">Sushil Bajracharya</a>
 * @created Sep 14, 2009
 *
 */
public class FqnFilterFactory extends BaseTokenFilterFactory {
	int extractSig = 0;
	int shortNamesOnly = 0; // will void the effect of fragment*
	

	@Override
	public void init(Map<String, String> args) {
		super.init(args);
		this.extractSig = getInt("extractSig", 0);

		this.shortNamesOnly = getInt("shortNamesOnly", 0);
	}

	public FqnFilter create(TokenStream input) {
		return new FqnFilter(input, extractSig, shortNamesOnly);
	}

	
}