package com.sample;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import com.sun.org.glassfish.external.amx.AMXGlassfish;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
        	Point point1 = new Point('A');
        	Point point2 = new Point('B');
        	Point point3 = new Point('C');        	
        	Point point4 = new Point('D');
        	Point point5 = new Point('G');
        	
        	GeoItem line1 = new Line(point1, point2);

        	GeoItem angle1 = new Angle(point1, point2, point3);
        	GeoItem angle2 = new Angle(point2, point3, point4);
        	
        	GeoRelation geoRelation = new GeoRelation(angle1, angle2, Relation.EQUALS);
        	

        	GeoItem angle3 = new Angle(point4, point2, point3);
        	GeoItem angle4 = new Angle(point2, point3, point1);
        	
        	GeoRelation geoRelation2 = new GeoRelation(angle3, angle4, Relation.EQUALS);

        	
            // load up the knowledge base
            KnowledgeBase kbase = readKnowledgeBase();
            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
            KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");

            
            ksession.insert(point1);
            ksession.insert(point2);
            ksession.insert(point3);
            ksession.insert(point4);
            ksession.insert(point5);
            
            ksession.insert(angle1);
            ksession.insert(angle2);
            
            ksession.insert(geoRelation);

            ksession.insert(angle3);
            ksession.insert(angle4);
            
            ksession.insert(geoRelation2);

             
            
            ksession.fireAllRules();
            logger.close();
            
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private static KnowledgeBase readKnowledgeBase() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("Sample.drl"), ResourceType.DRL);
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if (errors.size() > 0) {
            for (KnowledgeBuilderError error: errors) {
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        return kbase;
    }

    public static class Message {

        public static final int HELLO = 0;
        public static final int GOODBYE = 1;

        private String message;

        private int status;

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

    }

}
