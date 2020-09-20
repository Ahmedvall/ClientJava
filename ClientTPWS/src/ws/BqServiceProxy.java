package ws;

public class BqServiceProxy implements ws.BqService {
  private String _endpoint = null;
  private ws.BqService bqService = null;
  
  public BqServiceProxy() {
    _initBqServiceProxy();
  }
  
  public BqServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initBqServiceProxy();
  }
  
  private void _initBqServiceProxy() {
    try {
      bqService = (new ws.BanqueWSLocator()).getBqServicePort();
      if (bqService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bqService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bqService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bqService != null)
      ((javax.xml.rpc.Stub)bqService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ws.BqService getBqService() {
    if (bqService == null)
      _initBqServiceProxy();
    return bqService;
  }
  
  public ws.Compte getCompte(int code) throws java.rmi.RemoteException{
    if (bqService == null)
      _initBqServiceProxy();
    return bqService.getCompte(code);
  }
  
  public ws.Compte[] listCompte() throws java.rmi.RemoteException{
    if (bqService == null)
      _initBqServiceProxy();
    return bqService.listCompte();
  }
  
  public double conversionEuroToDh(double montant) throws java.rmi.RemoteException{
    if (bqService == null)
      _initBqServiceProxy();
    return bqService.conversionEuroToDh(montant);
  }
  
  
}