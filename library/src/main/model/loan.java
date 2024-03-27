 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Loan {
    private User user;
    private List<Publication> publications;
    private LocalDate startDate;
    private LocalDate endDate;

    public Loan(User user, LocalDate startDate, LocalDate endDate) {
        setUser(user);
        setStartDate(startDate);
        setEndDate(endDate);
        this.publications = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User is required.");
        }
        this.user = user;
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        if (startDate == null) {
            throw new IllegalArgumentException("Start date is required.");
        }
        if (startDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Start date cannot be in the future.");
        }
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        if (endDate == null) {
            throw new IllegalArgumentException("End date is required.");
        }
        if (endDate.isBefore(startDate) || endDate.isEqual(startDate)) {
            throw new IllegalArgumentException("End date must be after the start date.");
        }
        if (endDate.isAfter(LocalDate.now().plusYears(1))) {
            throw new IllegalArgumentException("End date cannot be more than one year in the future.");
        }
        this.endDate = endDate;
    }

    public void setPublications(List<Publication> publications) {
        for (Publication publication : publications) {
            if (publication.getAvailableCopies() <= 0) {
                throw new IllegalStateException(
                        "Unable to lend publication. No copies available for " + publication.getTitle());
            }
            publication.lendPublication();
            this.publications.add(publication);
        }
    }

    public void returnPublications() {
        for (Publication publication : publications) {
            publication.returnPublication();
        }
        publications.clear();
    }
}
