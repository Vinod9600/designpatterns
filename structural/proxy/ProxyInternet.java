package structural.proxy;

import java.util.ArrayList;
import java.util.List;

/**
 *  What is Proxy Patten ?
   The Proxy Design Pattern is a structural design pattern that enables us to create a stand-in or replacement for another object.
   Using a proxy, you may conduct an action either before or after the request reaches the original object, controlling access to it.
 *  Real Word Example
    1. Hibernate - Entity Lazy loading
    2. Network Proxy - It protected internet access via a network proxy on business networks. All network queries go through a proxy,
       which checks them for requests from domains that are approved before posting the data to the network.
    3. aspect-oriented programming (AOP)
 * Types of Proxies
    1.Remote Proxy
    2.Virtual Proxy
    3.Protection Proxy
    4.Smart Proxy
 * Advantages
    1 Security is one benefit of the proxy pattern.
    2.This design prevents the duplication of potentially enormously large and memory-intensive items.
        This improves the application’s performance.
    3. By installing a local code proxy (stub) on the client computer and then connecting to the server using remote code,
        the remote proxy also assures security.
 * Disadvantages -
    This pattern adds another layer of abstraction, which can occasionally cause problems if some clients access the
 Real subject code directly while others might access the Proxy classes. This could cause inconsistent behavior.
 * When to Use Proxy Design Pattern ?
    1.To provide a surrogate or placeholder for another object to control access to it.
    2.To support distributed, regulated, or intelligent access, add another indirection.
    3.To prevent the real component from becoming overly complex, add a wrapper and delegation.
 * Proxy vs Decorator Pattern
    The major distinction between the two patterns is the burdens each pattern carries. Decorators concentrate on adding duties,
    whereas proxies concentrate on restricting access to an object.
* Example : -
    A very simple real life scenario is our college internet, which restricts few site access.
 The proxy first checks the host you are connecting to, if it is not part of restricted site list, then it connects to the real internet.
 This example is based on Protection proxies.
 */
public class ProxyInternet implements Internet{
    private Internet internet = new RealInternet();
    private static List<String> bannedSites;

    static
    {
        bannedSites = new ArrayList<String>();
        bannedSites.add("abc.com");
        bannedSites.add("def.com");
        bannedSites.add("ijk.com");
        bannedSites.add("lnm.com");
    }

    @Override
    public void connectTo(String serverhost) throws Exception
    {
        if(bannedSites.contains(serverhost.toLowerCase()))
        {
            throw new Exception("Access Denied");
        }

        internet.connectTo(serverhost);
    }
}
