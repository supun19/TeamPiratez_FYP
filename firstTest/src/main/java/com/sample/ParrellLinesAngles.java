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

public class ParrellLinesAngles {

    public static final void main(String[] args) {
        try {

        	
        	Point pointa = new Point('A');
        	Point pointb = new Point('B');
        	Point pointc = new Point('C');        	
        	Point pointd = new Point('D');
        	Point pointe = new Point('E');

        	Line lineDE = new Line(pointd, pointe);
        	Line lineBC = new Line(pointb, pointc);
        	Line lineBE = new Line(pointb, pointe);
        	
    		GeoRelation DEParrBC = new GeoRelation(lineDE, lineBC, Relation.PARALLEL_LINES);

        	
            // load up the knowledge base
            KnowledgeBase kbase = readKnowledgeBase();
            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
            KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");

            

            ksession.insert(lineDE);
            ksession.insert(lineBC);
            ksession.insert(lineBE);

            ksession.insert(DEParrBC);
             
            
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
