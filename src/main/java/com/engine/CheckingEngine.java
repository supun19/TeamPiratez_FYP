package com.engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.io.AnswerGetter;
import com.knowledge.GeoDataHolder;
import com.knowledge.KnowledgeHolder;
import com.knowledge.StepStatus;
import com.knowledge.StudentAnswerHolder;
import com.sample.Angle;
import com.sample.GeoItem;
import com.sample.GeoRelation;
import com.sample.Line;
import com.sample.Point;
import com.sample.Reason;
import com.sample.Relation;

public class CheckingEngine {
	
	public static StudentAnswerHolder answerHolder;
	
	public static GeoDataHolder dataHolder;
	
	public static KnowledgeHolder inferedKnowledge;
	
	public static KnowledgeHolder studentAnswerKnowledgeHolder;
	
	KieServices ks;
    KieContainer kContainer;
	KieSession kSession;
	
	public CheckingEngine(){

	}
	
	
	//get data to answer holder
	//get data to data holder
	//add initial geo relation data to inferedknowledge
	
	
	/*
	 * algorithm
	 * 
	 * while there are elements in students answer
	 * 		if:element is present in inferred knowledge
	 * 			add element to studentAnswerKnowledgeHolder
	 * 			mark step as correct
	 * 		else
	 * 			run inference engine with loading  studentAnswerKnowledgeHolder
	 * 			add new knowledge to inferred knowledge
	 * 
	 * 			if:element is present in inferred knowledge
	 * 				student has missed a step
	 * 				current step is correct
	 * 			else
	 * 				current step is wrong
	 */
	
	
	public void check() throws Throwable{
		
		loadAnswer();
       
		//loadDataAnswerHolderDUMMY();
		
		loadInitialGeoItamDataDUMMY();
		
		loadInitialGeoRelationsDUMMY();
		
		studentAnswerKnowledgeHolder = new KnowledgeHolder();
		
		
		while (!answerHolder.endOfAnswer()) {
			
			GeoRelation step = answerHolder.getNextAnswerStep();
			
			if ( inferedKnowledge.relationExists(step) ){
				
				studentAnswerKnowledgeHolder.insertGeoRelation(step);
				
				System.out.println(step.getName() + " step is present in previously inferenced data");
				System.out.println("------------------------");
				
				answerHolder.markCurrentAnswer(StepStatus.CORRECT);
				
			}
			
			else{
				
				System.out.println(step.getName() + ": step IS NOT present previously inferenced data");
				
				System.out.println("Starting Inference Engine using students knowledge...");
				
				fireInfirenceEngine(studentAnswerKnowledgeHolder);
				
				studentAnswerKnowledgeHolder.printdata();
				
				
				
				if(inferedKnowledge.relationExists(step)){

					System.out.println(step.getName() + " step is present after inferencing using student given data");
					
					studentAnswerKnowledgeHolder.insertGeoRelation(step);

					answerHolder.markCurrentAnswer(StepStatus.CORRECT);

					System.out.println("------------------------");
					
				}
				else
				{
					//System.out.println("*****************************************8");
					System.out.println("Starting Inference Engine using infered data knowledge...");

					fireInfirenceEngine(inferedKnowledge);
					
					if(inferedKnowledge.relationExists(step)){
						
						studentAnswerKnowledgeHolder.insertGeoRelation(step);


						System.out.println(step.getName() + " step is present after inferencing using previously iferenced data");
						System.out.println("student has missed a step");
						System.out.println("------------------------");
						
						answerHolder.markCurrentAnswer(StepStatus.CORRECT_BUT_PREVIOUS_STEP_MISSING);

						
					}
					else{
						System.out.println(step.getName() + "step is wrong");
						System.out.println("------------------------");
						answerHolder.markCurrentAnswer(StepStatus.WRONG);

					}
					
					
					
				}
				
			}
	
		}
		answerHolder.printMarkedAnswer();
	}

	private void loadAnswer() {
		
		AnswerGetter answerGetter = new AnswerGetter();
		
		String filename = "C:\\Users\\Lahiru\\Downloads\\Final Year Project\\Implementation\\Answers\\test.txt"; // full correct
//		String filename = "E:\\eclipse\\data\\testdata2.txt"; // incorrect step
//		String filename = "E:\\eclipse\\data\\testdata3.txt"; // missing step

//		String filename = "E:\\eclipse\\data\\testdata1.txt"; // full correct
//		String filename = "E:\\eclipse\\data\\testdata1.txt"; // full correct
		
		try {

			answerHolder = new StudentAnswerHolder(answerGetter.readFile(filename));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public boolean fireInfirenceEngine(KnowledgeHolder knowledgeHolder){
		
		 ks = KieServices.Factory.get();
	    
		 kContainer = ks.getKieClasspathContainer();
    		
		 kSession = kContainer.newKieSession("ksession-rules");
		    
		 ArrayList<GeoRelation> allknowledge = knowledgeHolder.getFullKnowledge();
		 
		 for (Iterator<GeoRelation> iterator = allknowledge.iterator(); iterator.hasNext();) {
			
			 GeoRelation geoRelation = (GeoRelation) iterator.next();
			 
			// System.out.println(geoRelation.firstItem.getName() + geoRelation.secondItem.getName() + geoRelation.relation);
			
			 kSession.insert(geoRelation);
			
		}
		 
		 ArrayList<GeoItem> geoData = dataHolder.getAllGeoItemKnowledge();
		
		 for (Iterator<GeoItem> iterator = geoData.iterator(); iterator.hasNext();) {
			GeoItem geoItem = (GeoItem) iterator.next();
			
			kSession.insert(geoItem);
			
			// System.out.print(" |item "+geoItem.getName()+ " | ");
			
		}
		 
		 
			
		// System.out.println("ran");
        
        
        kSession.fireAllRules();
        
        kSession.dispose();
		
		return true;
	}

	private KnowledgeHolder loadInitialGeoRelationsDUMMY() {
		
		/*Point A = new Point('A');
		Point B = new Point('B');
		Point C = new Point('C');
		Point D = new Point('D');
		Point E = new Point('E');
		Point F = new Point('F');
		
		Line AB = new Line(A, B);
		Line CD = new Line(C, D);
		Line EF = new Line(E, F);
		Line AE = new Line(A, E);
		Line EB = new Line(E, B);
		Line CF = new Line(C, F);
		Line FD = new Line(F, D);
		
		Angle AEF = new Angle(EF,AE);
		Angle FEB = new Angle(EB,CD);
		Angle CFE = new Angle(CF, EF);
		Angle EFD = new Angle(EF, FD);
		
		
		GeoRelation ABparrCD = new GeoRelation(AB, CD, Relation.PARALLEL_LINES);
		GeoRelation AEparrCF = new GeoRelation(AE, CF, Relation.PARALLEL_LINES);
//		GeoRelation ABparrCD = new GeoRelation(AB, CD, Relation.PARALLEL_LINES);
		GeoRelation EonAB = new GeoRelation(AB, E, Relation.ON_THE_LINE);
		GeoRelation FonCD = new GeoRelation(CD, F, Relation.ON_THE_LINE);
		
		ArrayList<GeoRelation> initRelations = new ArrayList<GeoRelation>();
		
		initRelations.add(ABparrCD);
		initRelations.add(AEparrCF);

		initRelations.add(EonAB);
		initRelations.add(FonCD);
		
		inferedKnowledge = new KnowledgeHolder(initRelations);*/
		
		Point A = new Point('A');
		Point B = new Point('B');
		Point C = new Point('C');
		Point D = new Point('D');
		Point E = new Point('E');
		
		Line AB = new Line(A, B);
		Line BC = new Line(B, C);
		Line CD = new Line(C, D);
		Line CE = new Line(C, E);
		
		Angle ABC = new Angle(BC, AB);
		Angle DCE = new Angle(CD, CE);
		Angle BCD = new Angle(BC, CD);
		
		GeoRelation relData = new GeoRelation(BCD, DCE, Relation.EQUALS,Reason.දත්තය);
		
		GeoRelation relParrData = new GeoRelation(AB, CD, Relation.PARALLEL_LINES,Reason.දත්තය);
		
		ArrayList<GeoRelation> initRelations = new ArrayList<GeoRelation>();
		
		initRelations.add(relData);

		initRelations.add(relParrData);
		
		inferedKnowledge = new KnowledgeHolder(initRelations);
		
		return null;
	}


	private void loadInitialGeoItamDataDUMMY() {
		
		//Data for theorem 1
		/*Point A = new Point('A');
		Point B = new Point('B');
		Point C = new Point('C');
		Point D = new Point('D');
		Point E = new Point('E');
		Point F = new Point('F');
		Point G = new Point('G');
		
		Line AB = new Line(A, B);
		Line CD = new Line(C, D);
		Line EF = new Line(E, F);
		Line AE = new Line(A, E);
		Line EB = new Line(E, B);
		Line CF = new Line(C, F);
		Line FD = new Line(F, D);
		
		Angle AEF = new Angle(EF,AE);
		Angle FEB = new Angle(EB,CD);
		Angle CFE = new Angle(CF, EF);
		Angle EFD = new Angle(EF, FD);
		
		ArrayList<GeoItem> initData = new ArrayList<GeoItem>();
		
		initData.add(A);
		initData.add(B);
		initData.add(C);
		initData.add(D);
		initData.add(E);
		
		initData.add(AB);
		initData.add(CD);
		initData.add(EF);
		initData.add(AE);
		initData.add(EB);
		initData.add(CF);
		initData.add(FD);
		
		initData.add(AEF);
		initData.add(FEB);
		initData.add(CFE);
		initData.add(EFD);
		
		dataHolder = new GeoDataHolder(initData);*/

		Point A = new Point('A');
		Point B = new Point('B');
		Point C = new Point('C');
		Point D = new Point('D');
		Point E = new Point('E');
		
		Line AB = new Line(A, B);
		Line BC = new Line(B, C);
		Line CD = new Line(C, D);
		Line CE = new Line(C, E);
		
		Angle ABC = new Angle(BC,AB);
		Angle BCD = new Angle(BC,CD);
		Angle DCE = new Angle(CD, CE);
		
		ArrayList<GeoItem> initData = new ArrayList<GeoItem>();
		
		initData.add(A);
		initData.add(B);
		initData.add(C);
		initData.add(D);
		initData.add(E);
		
		initData.add(AB);
		initData.add(BC);
		initData.add(CD);
		initData.add(CE);
		
		initData.add(ABC);
		initData.add(BCD);
		initData.add(DCE);
		
		dataHolder = new GeoDataHolder(initData);
		
		
	}


	private void loadDataAnswerHolderDUMMY() {
		
		
		Point A = new Point('A');
		Point B = new Point('B');
		Point C = new Point('C');
		Point D = new Point('D');
		Point E = new Point('E');
		
		Line AB = new Line(A, B);
		Line BC = new Line(B, C);
		Line CD = new Line(C, D);
		Line CE = new Line(C, E);
		
		Angle ABC = new Angle(AB, BC);
		Angle BCD = new Angle(BC, CD);
		Angle DCE = new Angle(CD, CE);
		
		GeoRelation ABCeqBCD = new GeoRelation( ABC,  BCD, Relation.EQUALS);
		GeoRelation ABparrCD = new GeoRelation(AB, CD, Relation.PARALLEL_LINES);
		GeoRelation BCDeqDCE = new GeoRelation(BCD, DCE, Relation.EQUALS);
		GeoRelation wrongone = new GeoRelation(BCD, AB, Relation.EQUALS);
		
		ArrayList<GeoRelation> answers = new ArrayList<GeoRelation>();
		
		answers.add(BCDeqDCE);
		answers.add(wrongone);
		answers.add(ABparrCD);
		answers.add(ABCeqBCD);
		answers.add(wrongone);
		
		
		answerHolder = new StudentAnswerHolder(answers);
		
	}
	

}
