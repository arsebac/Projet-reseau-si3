package fr.unice.polytech.si3.reseau.protocol;

import common.Idea;
import common.Request;
import common.Response;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static common.Code.ADD_IDEA;
import static common.Code.GET_IDEA;

/**
 * @author François Melkonian
 */
public class MyProtocol {
	private List<Idea> ideas;
	public MyProtocol(){
		ideas = new ArrayList<Idea>();
	}
	public Response respond(Request request){
		if(request.getCode().equals(GET_IDEA.name())){

			return new Response(ideas);
		}else if(request.getCode().equals(ADD_IDEA.name())){
			Idea params = (Idea) request.getParams().get(0);
			ideas.add(params);
			return new Response(Collections.singletonList(ideas.size()));
		}
		return new Response(new ArrayList<String>(ideas.size()));
	}
	public String show(){
		return ideas.toString();
	}
}
