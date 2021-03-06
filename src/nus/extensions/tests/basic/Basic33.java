/**
   @author Benjamin Livshits <livshits@cs.stanford.edu>
   
   $Id: Basic33.java,v 1.2 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.PrintWriter;
import java.util.Enumeration;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/**
 * @servlet description="values obtained from headers"
 * @servlet vuln_count = "1"
 */
public class Basic33 extends MainActivity {
      protected void main(SourceEmulator req, SinkEmulator resp) {
        Enumeration e = req.getHeaders("Accept-Language");
        while(e.hasMoreElements()) {
            String header = (String) e.nextElement();
         
            PrintWriter writer = resp.getWriter();            
            writer.println(header);                      /* BAD */            
        }        
    }

    public String getDescription() {
        return "values obtained from headers";
    }

    public int getVulnerabilityCount() {
        return 1;
    }
}