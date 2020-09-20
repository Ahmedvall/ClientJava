/**
 * BqService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws;

public interface BqService extends java.rmi.Remote {
    public ws.Compte getCompte(int code) throws java.rmi.RemoteException;
    public ws.Compte[] listCompte() throws java.rmi.RemoteException;
    public double conversionEuroToDh(double montant) throws java.rmi.RemoteException;
}
