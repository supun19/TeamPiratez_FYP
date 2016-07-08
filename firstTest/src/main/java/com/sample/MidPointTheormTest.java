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



/**
 * This is a sample class to launch a rule.
 */
public class MidPointTheormTest {

    public static final void main(String[] args) {
        try {
        	Point pointa = new Point('A');
        	Point pointb = new Point('B');
        	Point pointc = new Point('C');        	
        	Point pointd = new Point('D');
        	Point pointe = new Point('E');
        	
        	GeoItem lineAB = new Line(pointa, pointb);
        	GeoItem lineAC = new Line(pointa, pointc);
        	GeoItem lineBC = new Line(pointb, pointc);

        	GeoRelation dOnLine = new GeoRelation(lineAB, pointd, Relation.ON_THE_LINE);
        	GeoRelation eOnLine = new GeoRelation(lineAC, pointe, Relation.ON_THE_LINE);
        	
        	GeoItem lineAD = new Line(pointa, pointd);
        	GeoItem lineDB = new Line(pointd, pointb);
        	GeoItem lineDE = new Line(pointd, pointe);

        	GeoRelation ADeqDB = new GeoRelation(lineAD, lineDB, Relation.EQUALS);

        	GeoItem lineAE = new Line(pointa, pointe);
        	GeoItem lineEC = new Line(pointe, pointc);



        	GeoRelation AEeqEC = new GeoRelation(lineAE, lineEC, Relation.EQUALS);
        	
            // load up the knowledge base
            KnowledgeBase kbase = readKnowledgeBase();
            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
            KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");

            
            ksession.insert(pointa);
            ksession.insert(pointb);
            ksession.insert(pointc);
            ksession.insert(pointd);
            ksession.insert(pointe);

            ksession.insert(lineDE);
            ksession.insert(lineBC);
            
            ksession.insert(dOnLine);
            ksession.insert(eOnLine);

            ksession.insert(AEeqEC);
            ksession.insert(ADeqDB);
             
            
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


    

}
