package jdt.quarkus;

import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;

public class JavaModelUtil {

	/**
	 * Resolves a type name in the context of the declaring type.
	 *
	 * @param refTypeSig    the type name in signature notation (for example
	 *                      'QVector') this can also be an array type, but
	 *                      dimensions will be ignored.
	 * @param declaringType the context for resolving (type where the reference was
	 *                      made in)
	 * @return returns the fully qualified type name or build-in-type name. if a
	 *         unresolved type couldn't be resolved null is returned
	 * @throws JavaModelException thrown when the type can not be accessed
	 */
	public static String getResolvedTypeName(String refTypeSig, IType declaringType) throws JavaModelException {
		int arrayCount = Signature.getArrayCount(refTypeSig);
		char type = refTypeSig.charAt(arrayCount);
		if (type == Signature.C_UNRESOLVED) {
			String name = ""; //$NON-NLS-1$
			int bracket = refTypeSig.indexOf(Signature.C_GENERIC_START, arrayCount + 1);
			if (bracket > 0)
				name = refTypeSig.substring(arrayCount + 1, bracket);
			else {
				int semi = refTypeSig.indexOf(Signature.C_SEMICOLON, arrayCount + 1);
				if (semi == -1) {
					throw new IllegalArgumentException();
				}
				name = refTypeSig.substring(arrayCount + 1, semi);
			}
			String[][] resolvedNames = declaringType.resolveType(name);
			if (resolvedNames != null && resolvedNames.length > 0) {
				return JavaModelUtil.concatenateName(resolvedNames[0][0], resolvedNames[0][1]);
			}
			return null;
		} else {
			return Signature.toString(refTypeSig.substring(arrayCount));
		}
	}

	/**
	 * Concatenates two names. Uses a dot for separation. Both strings can be empty
	 * or <code>null</code>.
	 * 
	 * @param name1 the first name
	 * @param name2 the second name
	 * @return the concatenated name
	 */
	public static String concatenateName(String name1, String name2) {
		StringBuffer buf = new StringBuffer();
		if (name1 != null && name1.length() > 0) {
			buf.append(name1);
		}
		if (name2 != null && name2.length() > 0) {
			if (buf.length() > 0) {
				buf.append('.');
			}
			buf.append(name2);
		}
		return buf.toString();
	}
}
