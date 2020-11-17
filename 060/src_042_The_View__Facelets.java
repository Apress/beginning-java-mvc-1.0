// Composers.java:
package book.javamvc.musicbox.model;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.google.common.collect.Lists;

@SessionScoped
@Named
public class Composers implements Serializable {
    private static final long serialVersionUID = 
        -5244686848723761341L;

    public List<String> getComposers() {
        return Lists.newArrayList("Brahms, Johannes",
              "Debussy, Claude");
    }
}

// Titles.java:
package book.javamvc.musicbox.model;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.google.common.collect.Lists;

@SessionScoped
@Named
public class Titles implements Serializable {
    private static final long serialVersionUID = 
        -1034755008236485058L;

    public List<String> getTitles() {
        return Lists.newArrayList("Symphony 1",
            "Symphony 2", "Childrens Corner");
    }
}


// Performers.java:
package book.javamvc.musicbox.model;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.google.common.collect.Lists;

@SessionScoped
@Named
public class Performers implements Serializable {
    private static final long serialVersionUID = 
        6941511768526140932L;

    public List<String> getPerformers() {
        return Lists.newArrayList(
            "Gewandhausorchester Leipzig",
            "Boston Pops");
    }
}
