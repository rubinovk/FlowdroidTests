/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
   
    $Id: Basic16.java,v 1.4 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;
public class Basic16 extends MainActivity {
    public class Widget {
        String contents;

        public String getContents() {
            return contents;
        }

        public void setContents(String contents) {
            this.contents = contents;
        }
    }

    private static final String FIELD_NAME = "name";

	public void main(SourceEmulator source, SinkEmulator sink)
	{
        String s = source.getParameter(FIELD_NAME);
        Widget w = new Widget();
        w.setContents(s);
        

        PrintWriter writer = sink.getWriter();
        writer.println(w.getContents());                    /* BAD */
    }
    
    public String getDescription() {
        return "simple heap-allocated data strucure";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}