package com.knowledge;

import java.util.ArrayList;

import com.sample.GeoRelation;

public class StudentAnswerHolder {
	
	private ArrayList<GeoRelation> answers = new ArrayList<GeoRelation>();
	
	private ArrayList<StepStatus> status = new ArrayList<StepStatus>();
	
	private int currentPosition;

	public StudentAnswerHolder(ArrayList<GeoRelation> answers){

		this.answers = answers;
		
		currentPosition = 0;
	
	}
	public void initPostion(){
		currentPosition = 0;
	}
	public GeoRelation getNextAnswerStep(){

		if( endOfAnswer() ) return null;
		
		return answers.get(currentPosition++);

	}
	
	public boolean endOfAnswer(){
		
		return currentPosition >= answers.size();

	}
	
	public boolean markCurrentAnswer(StepStatus status){
		
		this.status.add( status );
		
		return true;
	}
	
	public void printAnswer(){
		
		for (int i = 0; i < answers.size() ; i++) {
			
			System.out.println(answers.get(i).getName());

		}
	}
	
	public void printMarkedAnswer(){
		
		for (int i = 0; i < answers.size() ; i++) {
			
			System.out.println(answers.get(i).getName() + "\t\t" + status.get(i).name());

		}
	}
	public StepStatus getStatusFromCurrentRelation(){
		return status.get(currentPosition-1);
	}

	public ArrayList<StepStatus> getStatus() {
		return status;
	}

	public void setStatus(ArrayList<StepStatus> status) {
		this.status = status;
	}

	public ArrayList<GeoRelation> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<GeoRelation> answers) {
		this.answers = answers;
	}
	
	public void printAfterGiveMark() {
		// TODO Auto-generated method stub
for (int i = 0; i < answers.size() ; i++) {
			
			System.out.println("step"+i+"     "+answers.get(i).getMarkforrelation() + "\t\t" + answers.get(i).getMarkforreason());

		}
	}
	

}
