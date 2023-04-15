import javax.sound.midi.*;

public class MidiPlayer {
    public static void main(String[] args) {
        try {
            // Load MIDI file
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.setSequence(MidiSystem.getSequence(MidiPlayer.class.getResourceAsStream("midifile.mid"))); // Replace "example.mid" with the path to your MIDI file

            // Start playing MIDI file
            sequencer.start();

            // Wait for the MIDI file to finish playing
            while (sequencer.isRunning()) {
                Thread.sleep(100);
            }

            // Close the sequencer
            sequencer.stop();
            sequencer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
