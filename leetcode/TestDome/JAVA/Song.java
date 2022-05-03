package TestDome.JAVA;

public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isRepeatingPlaylist() {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
        // while(this.nextSong!=null){
        //     if(this.name==this.nextSong.name){
        //         return true;
        //     }
        //     this.nextSong=this.nextSong.nextSong;
        // }
        // return false;
        // 1   2     3     4    5
        //    slow  fast  
        //          slow       fast
        Song slow = this.nextSong;
        Song fast = slow == null ? null : slow.nextSong;
        while (fast != null) {
            if (slow == this || slow == fast)
                return true;
            slow = slow.nextSong;
            fast = fast.nextSong;
            if (fast != null)
                fast = fast.nextSong;
        }
        return false;
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        second.setNextSong(first);

        System.out.println(first.isRepeatingPlaylist());
    }
}
