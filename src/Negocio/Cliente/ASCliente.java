/**
 * 
 */
package Negocio.Cliente;

import java.util.ArrayList;



/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Paulo Colombo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface ASCliente {
	public int altaCliente(TCliente tCliente) throws Exception;
    public int bajaCliente(int id) throws Exception;
    public int modificarCliente(TCliente t) throws Exception;
    public TCliente detalleCliente(int id) throws Exception;
    public ArrayList<TCliente> listaCliente() throws Exception;
	public TCliente clienteVip();
}