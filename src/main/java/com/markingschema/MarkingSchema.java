package com.markingschema;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;

import java.io.File;

import javax.xml.bind.JAXBException;

import javax.xml.bind.Unmarshaller;

public class MarkingSchema {
	public static void main(String args[]) {
		MarkingSchema markingSchema = new MarkingSchema();
		String path="src/main/java/com/markingschema/MarkingScheme.xml";
		//Document doc=markingSchema.readXml(path);
		AnswerScript answerscript= markingSchema.MarkingSchemaXmlMaper(path);
		//AnswerPattern answerPattern=new AnswerPattern();
		//List<AnswerPattern> patterns=answerPattern.getPosibleAnswerPattern(answerscript);
		
	}

	
	public AnswerScript MarkingSchemaXmlMaper(String path){
		AnswerScript answerScript = null;
		File file = new File(path);
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(AnswerScript.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			answerScript = (AnswerScript) jaxbUnmarshaller.unmarshal(file);
			 
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*for (Step step : answerScript.getQuestion().get(0).getSubQuestion().get(0).getMarkSet().getStep()) {
			if(step.getReason()!=null){
				System.out.println(step.getReason().answer);
			}
			
		}*/
		/*System.out.println(answerScript.getQuestion().get(0).getSubQuestion().get(0).getMarkSet().getStep().get(0).getReason().answer);
		*/return answerScript;
	}
	
}
