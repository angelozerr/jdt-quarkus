package jdt.quarkus.plugin.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMemberValuePair;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

public class MetadaQuarkusHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
//		MessageDialog.openInformation(
//				window.getShell(),
//				"Jdt-quarkus-plugin",
//				"Collect Quarkup metadata");

		// test with
		// https://github.com/quarkusio/quarkus-quickstarts/tree/master/getting-started
		IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject("getting-started");
		IJavaProject project = JavaCore.create(p);

		scanConfigItem();
		return null;
	}

	public static Object getMemberValue(IAnnotation annotation, String memberName) {
		try {
			for (IMemberValuePair pair : annotation.getMemberValuePairs()) {
				if (memberName.equals(pair.getMemberName())) {
					return pair.getValue();
				}
			}
		} catch (JavaModelException e) {
			//e.printStackTrace();
		}
		return null;
	}

	private static IJavaSearchScope createSearchScope() throws JavaModelException {
		IJavaProject[] projects = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot()).getJavaProjects();
		return SearchEngine.createJavaSearchScope(projects,
				IJavaSearchScope.SOURCES | IJavaSearchScope.SYSTEM_LIBRARIES | IJavaSearchScope.APPLICATION_LIBRARIES);
	}

	private static void scanConfigProperty() {
		SearchPattern pattern = SearchPattern.createPattern("ConfigProperty", IJavaSearchConstants.ANNOTATION_TYPE,
				IJavaSearchConstants.ANNOTATION_TYPE_REFERENCE, SearchPattern.R_EXACT_MATCH);
		SearchEngine engine = new SearchEngine();
		try {
			engine.search(pattern, new SearchParticipant[] { SearchEngine.getDefaultSearchParticipant() },
					createSearchScope(), new SearchRequestor() {

						@Override
						public void acceptSearchMatch(SearchMatch match) throws CoreException {
							Object element = match.getElement();
							if (element instanceof IField) {
								IAnnotation annotation = ((IField) element).getAnnotation("ConfigProperty");
								String value = (String) getMemberValue(annotation, "name");
								System.err.println(value);
							} else if (element instanceof IMethod) {
								IMethod method = (IMethod) element;
								IAnnotation annotation = method.getAnnotation("ConfigProperty");
								annotation.getOpenable().open(new NullProgressMonitor());
								if (annotation.getOpenable().isOpen()) {
									String value = (String) getMemberValue(annotation, "name");
									System.err.println(value);
								}
							}
						}
					}, new NullProgressMonitor());
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void scanConfigItem() {
		SearchPattern pattern = SearchPattern.createPattern("ConfigItem", IJavaSearchConstants.ANNOTATION_TYPE,
				IJavaSearchConstants.ANNOTATION_TYPE_REFERENCE, SearchPattern.R_EXACT_MATCH);
		SearchEngine engine = new SearchEngine();
		try {
			engine.search(pattern, new SearchParticipant[] { SearchEngine.getDefaultSearchParticipant() },
					createSearchScope(), new SearchRequestor() {

						@Override
						public void acceptSearchMatch(SearchMatch match) throws CoreException {
							Object element = match.getElement();
							if (element instanceof IField) {
								IAnnotation annotation = ((IField) element).getAnnotation("ConfigItem");
								annotation.getOpenable().open(new NullProgressMonitor());
								String value = (String) getMemberValue(annotation, "defaultValue");
								System.err.println(value);
							} else if (element instanceof IMethod) {
								IMethod method = (IMethod) element;
								IAnnotation annotation = method.getAnnotation("ConfigItem");
								annotation.getOpenable().open(new NullProgressMonitor());
								if (annotation.getOpenable().isOpen()) {
									String value = (String) getMemberValue(annotation, "defaultValue");
									System.err.println(value);
								}
							}
						}
					}, new NullProgressMonitor());
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

	
	public static IType getFieldType(IField field) {
		String signature;
		try {
			signature = field.getTypeSignature();
			IType primaryType = field.getTypeRoot().findPrimaryType();
			String name = null;// JavaModelUtil.getResolvedTypeName(signature, primaryType);
			if (name == null) {
				return null;
			}
			return field.getJavaProject().findType(name);
		} catch (JavaModelException e) {
			// DataHierarchyPlugin.logError("getFieldType() failed for field: " + field, e);
		}
		return null;
	}
}
