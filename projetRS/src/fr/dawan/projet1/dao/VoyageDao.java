package fr.dawan.projet1.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import fr.dawan.projet1.ws.beans.Voyage;


//@Singleton
@Named
@ApplicationScoped
public class VoyageDao {

	private static List<Voyage> lv;
	
	static{
		lv	= Collections.synchronizedList(new ArrayList<>());
		lv.add(new Voyage(1L, "Paris", "Tokyo", new Date()));
		lv.add(new Voyage(2L, "Chambéry", "La ravoire", new Date()));
	}

	public List<Voyage> lister() {
	  	Collections.sort(lv, (x,y) -> (int) (x.getId() - y.getId()));
		return lv;
	}
	
	public Voyage rechercher(long id) {
//		int ind = lv.indexOf(new Voyage(id,null,null,null));
//		return (ind==-1) ? null : lv.get(ind);
		Voyage voyage = lv.stream().filter( x -> x.getId()==id).findFirst().get();
		return voyage;

	}
	
	public boolean supprimer(long id) {
		int ind = lv.indexOf(new Voyage(id,null,null,null));
		if(ind==-1)
			return false;
		lv.remove(ind);
		return true;
	}
	
	public boolean modifier(Voyage v) {
		if(!lv.contains(v))
			return false;
		lv.remove(v);
		return lv.add(v);
	}
	

	public Voyage ajouter(Voyage v) {
		v.setId(lv.size()+1);
		lv.add(v);
		return v;
	}

}
