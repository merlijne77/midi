/**
 * Returns the played note name to string.
 * @author heidi
 */
package MidiToNotes;

public class Note {

    private static final String[] NOTE_NAMES = {"C", "C#", "D", "D#", "E", "F", "F#",
    		"G", "G#", "A", "A#", "B"};

    public static String name;
    private int key;
    private int octave;
 
     public Note(int key) {
        this.key = key;
        this.octave = (key / 12)-1;
        int note = key % 12;
        Note.name = NOTE_NAMES[note];
   }

    @Override
    public String toString() {
        return name;
        //return "Note -> " + this.name + this.octave + " key=" + this.key;
    }
    

//  @Override
//  public boolean equals(Object obj) {
//      return obj instanceof Note && this.key == ((Note) obj).key;
//  }

}