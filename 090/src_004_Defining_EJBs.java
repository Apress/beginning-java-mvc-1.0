  public interface InvoiceInterface {
      ... abstract interface methods
  }

  @Stateless  
  @Local(InvoiceInterface.class)
  public class Invoice implements InvoiceInterface {
      ... implementation
  }
