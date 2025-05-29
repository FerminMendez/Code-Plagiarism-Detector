package tr0llhoehle.cakemix.utility.googleCodeJam;

import java.text.ParseException;

/**
 * This class is a base class for all concrete problems. It is used to define
 * some methods necessary for the IOManager to work. It is crucial that the
 * addValue-Method gets extended and called (super.addValue(o)) by the extending
 * class.
 * 
 * @author Cakemix
 * @see IOManager
 * @see Solver
 */
public abstract class Problem {

    protected SupportedTypes[] types;
    protected int cntr = 0;
    protected boolean isInitialised = false;

    /**
     * Returns an array of SupportedTypes which define exactly what data is
     * stored in this problem.
     * 
     * The attribute "types" needs to be initialized in the constructor of the
     * extending class.
     * 
     * @return An array of SupportedTypes which define exactly what data is
     *         stored in this problem.
     * @see SupportedTypes
     */
    public SupportedTypes[] getTypes() {
	return types;
    }

    public void addValue(Object o) throws ParseException {
	if (!isInitialised) {
	    cntr++;
	    isInitialised = (cntr == types.length);
	} else {
	    throw new ParseException("Tried to add another value to this Problem even though all values are set.", cntr);
	}
    }
}
