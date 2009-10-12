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
package edu.uci.ics.sourcerer.scs.server;


import java.util.LinkedList;
import java.util.List;
import java.util.Properties;



import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.uci.ics.sourcerer.db.adapter.JdbcDataSource;
import edu.uci.ics.sourcerer.db.adapter.SourcererDbAdapter;
import edu.uci.ics.sourcerer.scs.client.ERTables;
import edu.uci.ics.sourcerer.scs.client.SourcererDBService;

/**
 * @author <a href="bajracharya@gmail.com">Sushil Bajracharya</a>
 * @created Jul 22, 2009
 *
 */
public class SourcererDBServiceImpl extends RemoteServiceServlet implements
	SourcererDBService {
	
	JdbcDataSource ds = new JdbcDataSource();
	SourcererDbAdapter dba = new SourcererDbAdapter();
	
	public void init(){
		
		//TODO read all values from web.xml
		Properties p = new Properties();
	    p.put("driver", "com.mysql.jdbc.Driver");
	    p.put("url", "jdbc:mysql://tagus.ics.uci.edu:3306/sourcerer");
	    p.put("user", "sourcerer-public");
	    p.put("password", "");
	    ds.init(p);
	    
	    dba.setDataSource(ds);
	}

	public ERTables getERTables(List<String> hitEntities) {
		
		return dba.buildDbForHitEntities(hitEntities);
		
	}
	
	
}