    ...
    private LocalDate dateOfBirth;
    ...

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getDateOfBirthDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(dateOfBirth.getYear(), 
                dateOfBirth.getMonthValue()-1, 
                dateOfBirth.getDayOfMonth(),
                0, 0, 0);
        return cal.getTime();
    }

    public void setDateOfBirth(
          LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
