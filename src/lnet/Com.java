
package lnet;

import tnet.communication.TNetData;

public interface Com
{

    public <D> void write(D obj);

    public <D> TNetData<D> read();

}
