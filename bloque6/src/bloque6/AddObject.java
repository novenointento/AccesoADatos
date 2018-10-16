/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloque6;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author gnord
 */
public class AddObject extends ObjectOutputStream {

    public AddObject(OutputStream out) throws IOException {
        super(out);//coje el construcctor del padre
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        reset(); // no escribe la cabecera
    }
}
