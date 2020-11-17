package book.javamvc.bk;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mvc.Controller;
import javax.mvc.binding.BindingResult;
import javax.mvc.binding.MvcBinding;
import javax.mvc.binding.ParamError;
import javax.validation.constraints.Pattern;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import book.javamvc.bk.db.Book;
import book.javamvc.bk.db.BookDAO;
import book.javamvc.bk.db.Member;
import book.javamvc.bk.db.MemberDAO;
import book.javamvc.bk.db.RentalDAO;
import book.javamvc.bk.model.BookModel;
import book.javamvc.bk.model.BookSearchResult;
import book.javamvc.bk.model.CurrentMember;
import book.javamvc.bk.model.MemberSearchResult;


// http://localhost:8080/BooKlubb
@Path("/bk")
@Controller
public class BooKlubbController {
	@Named
	@RequestScoped
	public static class ErrorMessages {
		private List<String> msgs = new ArrayList<>();
		
		public List<String> getMsgs() {
			return msgs;
		}

		public void setMsgs(List<String> msgs) {
			this.msgs = msgs;
		}

		public void addMessage(String msg) {
			msgs.add(msg);
		}
	}

//	private @Inject UserData userData;
	private @Inject ErrorMessages errorMessages;
	private @Inject BindingResult br;
	
	private @EJB MemberDAO memberDao;
	private @Inject MemberSearchResult memberSearchResult;

	private @EJB BookDAO bookDao;
	private @Inject BookSearchResult bookSearchResult;

	private @EJB RentalDAO rentalDao;

	private @Inject CurrentMember currentMember;	
		
    @GET
    // http://localhost:8080/BooKlubb
    public String showIndex() {
        return "index.jsp";
    }
    
    @GET
    @Path("/searchMember")
    public Response searchMember() {
        return Response.ok("searchMember.jsp").build();
    }

    @GET
    @Path("/newMember")
    public Response newMember() {
        return Response.ok("newMember.jsp").build();
    }

    @GET
    @Path("/searchBook")
    public Response searchBook() {
        return Response.ok("searchBook.jsp").build();
    }

    @GET
    @Path("/newBook")
    public Response newBook() {
        return Response.ok("newBook.jsp").build();
    }

    @GET
    @Path("/searchMemberSubmit")
    public Response searchMemberSubmit(
        @MvcBinding @QueryParam("firstName") 
            String firstName,
        @MvcBinding @QueryParam("lastName") 
            String lastName,
        @MvcBinding @QueryParam("ssn") 
            String ssn) {
    	showErrors();
    	
    	String ssnNormal = ssn == null ? "" : ( ssn.replaceAll("\\D", "") );
    	List<Member> l = new ArrayList<>();
    	if(!ssnNormal.isEmpty()) {
    		memberDao.memberBySsn(ssnNormal).ifPresent(m1 -> { l.add(m1); });
    	} else {
    		l.addAll( memberDao.membersByName(firstName, lastName) );
    	}
    	memberSearchResult.addAll(l);
    	
        return Response.ok("searchMemberResult.jsp").build();
    }

    @POST
    @Path("/newMemberSubmit")
    public Response newMemberSubmit(
        @MvcBinding @FormParam("firstName") 
            String firstName,
        @MvcBinding @FormParam("lastName") 
            String lastName,
        @MvcBinding @FormParam("birthday") 
            @Pattern(regexp = "\\d\\d/\\d\\d/\\d\\d\\d\\d")
            String birthday,
        @MvcBinding @FormParam("ssn") 
            String ssn) {
    	showErrors();
    	
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    	LocalDate ld = LocalDate.parse(birthday, dtf);
    	Date date = Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
    	
    	memberDao.addMember(firstName, lastName, date, ssn);
    	
        return Response.ok("newMemberResult.jsp").build();
    }
    
    @POST
    @Path("/deleteMember")
    public Response deleteMember(
        @MvcBinding @FormParam("memberId") 
            int memberId) {
    	showErrors();
    	
    	memberDao.deleteMember(memberId);
    	
        return Response.ok("deleteMemberResult.jsp").build();
    }

    @POST
    @Path("/selectMember")
    public Response selectMember(
        @MvcBinding @FormParam("memberId") 
            int memberId) {
    	showErrors();
    	
    	Member m = memberDao.memberById(memberId);
    	currentMember.setId(memberId);
    	currentMember.setFirstName(m.getFirstName());
    	currentMember.setLastName(m.getLastName());
    	currentMember.setBirthday(m.getBirthday());
    	currentMember.setSsn(m.getSsn());
    	currentMember.setDefined(true);
    	
        return Response.ok("index.jsp").build();
    }
    
    @POST
    @Path("/memberDetails")
    public Response memberDetails(
        @MvcBinding @FormParam("memberId") 
            int memberId) {
    	showErrors();
    	
    	Member m = memberDao.memberById(memberId);
    	currentMember.setId(memberId);
    	currentMember.setFirstName(m.getFirstName());
    	currentMember.setLastName(m.getLastName());
    	currentMember.setBirthday(m.getBirthday());
    	currentMember.setSsn(m.getSsn());
    	currentMember.setRentals(
    			m.getRental().stream().map(r -> {
    				Book b = r.getBook();
    				return new BookModel(b.getId(), b.getAuthorFirstName(), b.getAuthorLastName(), b.getTitle(), b.getIsbn(), b.getMake());
    			}).collect(Collectors.toSet())
    			);
    	currentMember.setDefined(true);
    	
        return Response.ok("memberDetails.jsp").build();
    }
    
    @GET
    @Path("/searchBookSubmit")
    public Response searchBookSubmit(
        @MvcBinding @QueryParam("authorFirstName") 
            String authorFirstName,
        @MvcBinding @QueryParam("authorLastName") 
            String authorLastName,
        @MvcBinding @QueryParam("bookTitle") 
            String bookTitle,
        @MvcBinding @QueryParam("isbn") 
            String isbn) {
    	showErrors();
    	
    	String isbnNormal = isbn == null ? "" : ( isbn.replaceAll("\\D", "") );
    	List<Book> l = new ArrayList<>();
    	if(!isbnNormal.isEmpty()) {
    		bookDao.bookByIsbn(isbnNormal).ifPresent(m1 -> { l.add(m1); });
    	} else {
    		l.addAll( bookDao.booksByName(authorFirstName, authorLastName, bookTitle) );
    	}
    	bookSearchResult.addAll(l);
    	
        return Response.ok("searchBookResult.jsp").build();
    }

    @POST
    @Path("/newBookSubmit")
    public Response newBookSubmit(
        @MvcBinding @FormParam("authorFirstName") 
            String authorFirstName,
        @MvcBinding @FormParam("authorLastName") 
            String authorLastName,
        @MvcBinding @FormParam("title") 
            String bookTitle,
        @MvcBinding @FormParam("make") 
        @Pattern(regexp = "((\\d\\d/)?\\d\\d/)?\\d\\d\\d\\d")
            String make,
        @MvcBinding @FormParam("isbn") 
            String isbn) {
    	showErrors();
    	
    	String isbnNormal = isbn == null ? "" : ( isbn.replaceAll("\\D", "") );
    	String makeNormal = make == null ? "" : (
    			make.matches("\\d\\d\\d\\d") ? "01/01/" + make :
    				(make.matches("\\d\\d/\\d\\d\\d\\d") ? make.substring(0,2) + "/01" + 
    			     make.substring(2) : make)
    	);
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    	LocalDate ld = LocalDate.parse(makeNormal, dtf);
    	Date date = Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
    	
    	bookDao.addBook(authorFirstName, authorLastName, bookTitle, date, isbnNormal);
    	
        return Response.ok("newBookResult.jsp").build();
    }

    @POST
    @Path("/deleteBook")
    public Response deleteBook(
        @MvcBinding @FormParam("bookId") 
            int bookId) {
    	showErrors();
    	
    	bookDao.deleteBook(bookId);
    	
        return Response.ok("deleteBookResult.jsp").build();
    }

    @POST
    @Path("/assignBook")
    public Response assignBook(
       @MvcBinding @FormParam("bookId") 
            int bookId,
       @MvcBinding @FormParam("userId") 
            int userId) {
    	showErrors();
    	
    	Book b = bookDao.bookById(bookId);
    	Member m = memberDao.memberById(userId);
    	Date now = new Date();
    	rentalDao.rentBook(b, m, now);
    	
        return Response.ok("index.jsp").build();
    }

    @POST
    @Path("/unassignBook")
    public Response unassignBook(
       @MvcBinding @FormParam("bookId") 
            int bookId,
       @MvcBinding @FormParam("memberId") 
            int userId) {
    	showErrors();
    	
    	Book b = bookDao.bookById(bookId);
    	Member m = memberDao.memberById(userId);
    	rentalDao.unrentBook(b, m);

    	currentMember.setRentals(
    			m.getRental().stream().map(r -> {
    				Book bb = r.getBook();
    				return new BookModel(bb.getId(), bb.getAuthorFirstName(), bb.getAuthorLastName(), bb.getTitle(), bb.getIsbn(), bb.getMake());
    			}).collect(Collectors.toSet())
    			);

        return Response.ok("memberDetails.jsp").build();
    }
    
    /////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////
    
	private void showErrors() {
		if(br.isFailed()) {
    		br.getAllErrors().stream().forEach((ParamError pe) -> {
    			errorMessages.addMessage(pe.getParamName() + ": " + pe.getMessage());
    		});
    	}
	}
}
