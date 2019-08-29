package jdt.quarkus.plugin.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.lsp4j.Location;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.gson.Gson;
import com.redhat.quarkus.commons.QuarkusProjectInfo;
import com.redhat.quarkus.jdt.core.DocumentationConverter;
import com.redhat.quarkus.jdt.core.JDTQuarkusManager;

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
		IFile file = JDTUtils.findFile(
				"file:///c%3A/Users/azerr/git/quarkus-quickstarts/hibernate-orm-resteasy/src/main/resources/application.properties");
		String projectName = file.getProject().getName();
		
		projectName = "hibernate-orm-resteasy";
		try {
			QuarkusProjectInfo properties = JDTQuarkusManager.getInstance().getQuarkusProjectInfo(projectName,
					DocumentationConverter.DEFAULT_CONVERTER, new NullProgressMonitor());
			String s = new Gson().toJson(properties);
			System.err.println(s);
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Location location;
//		try {
//			location = JDTQuarkusManager.getInstance().findDefinition(projectName, "io.quarkus.runtime.ThreadPoolConfig#coreThreads");
//			String s = new Gson().toJson(location);
//			System.err.println(s);
//		} catch (JavaModelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return null;
	}

}
