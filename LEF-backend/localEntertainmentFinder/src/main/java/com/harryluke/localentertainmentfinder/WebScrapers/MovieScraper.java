package com.harryluke.localentertainmentfinder.WebScrapers;
import com.harryluke.localentertainmentfinder.Movies.Movie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TODO create the webscraper
@Service
public class MovieScraper {

    String[] urls = new String[]{"https://www.lidocinemas.com.au/events/cult-classics-439"};

    public List<Movie> scrape(){
        List<Movie> movieList = new ArrayList<>();
        for(String url : urls){
            try {
                // Connect to the website and fetch the HTML
                Document document = Jsoup.connect(url).get();
                Element moviesList = document.selectFirst("ul.Movies.Multiple");

                if (moviesList != null) {
                    // Select all <li> elements within the <ul>
                    Elements movieItems = moviesList.select("li.Item");

                    // Iterate over the <li> elements
                    for (Element movieItem : movieItems) {
                        // Extract relevant information from each movie item
                        String title = movieItem.selectFirst(".Title a").text();
                        String premiereDate = movieItem.selectFirst(".Byline .MoviePremiere").text();
                        String imageUrl = movieItem.selectFirst(".Image img").attr("src");

                        System.out.println("Title: " + title);
                        System.out.println("Premiere Date: " + premiereDate);
                        System.out.println("Image URL: " + imageUrl);

                        // Add more extraction logic as needed
                        System.out.println();
                    }
                } else {
                    System.out.println("Unable to find the Movies List with the specified class.");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return movieList;
    }

}
