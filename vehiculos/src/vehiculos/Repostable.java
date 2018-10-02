/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiculos;

/**
 *
 * @author gnord
 */
public interface Repostable {
    public boolean repostar(float litrosARepostar,String combustible) throws MisExcepciones.ErrorRepostaje,MisExcepciones.ErrorCombustible;
}
