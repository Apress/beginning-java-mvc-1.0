public class SomeClass {
  private final static Logger LOG = 
        LogManager.getLogger(SomeClass.class);
  ...
  public void someMethod() {
    ...
    LOG.trace("Trace: ...");
    LOG.debug("Debug: ...");
    LOG.info("Some info: ...");
    LOG.warn("Some warning: ...");
    LOG.error("Some error: ...");
    LOG.fatal("Some fatal error: ...");
    ...
    try {
       ...
    } catch(Exception e) {
       ...
       LOG.error("Some error", e);
    }
  }
}
