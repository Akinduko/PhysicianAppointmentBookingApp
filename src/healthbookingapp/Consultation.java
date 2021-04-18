/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp;
import java.util.HashMap;

/**
 *
 * @author olugbengaakinduko
 */
public class Consultation {
    
        private String id;
        private String room;
        private String time;
        private enum LookupKey { id, room, time };
    

	public Consultation(HashMap<LookupKey, String> props) {
		this.setId(props.get(LookupKey.id));
		this.setRoom(props.get(LookupKey.room));
                this.setTime(props.get(LookupKey.time));
	}
	    
        private void setRoom(String room){
            this.room = room;
        }
        
        private void setTime(String time){
            this.time = time;
        }
    
        private void setId(String id){
            this.id = id;
        }
    
}
