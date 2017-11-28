package fr.inria.phoenix.diasuite.framework.datatype.updatingstep;

import java.io.Serializable;

/**
 * <pre>
enumeration UpdatingStep {
 * 	INIT_UPDATING, VALID_PASS_1, WRONG_PASSWORD, VALID_PASS_2, END_UPDATING, CANCEL_UPDATING
 * }
</pre>
 */
public enum UpdatingStep implements Serializable {
    INIT_UPDATING,VALID_PASS_1,WRONG_PASSWORD,VALID_PASS_2,END_UPDATING,CANCEL_UPDATING
}
