package day0511.example;

public class Song {
	String title;
	String artist;
	int year;
	String country;
	
	public Song(){}
	public Song(String title, String artist, int year, String country) {
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.country = country;
		}
	void show() {
		System.out.println(country+", "+year+"년 "+artist+" "+title);
	}
}