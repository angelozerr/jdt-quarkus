package jdt.quarkus.plugin.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.jboss.tools.quarkus.lsp4e.internal.JDTUtils;
import org.jboss.tools.quarkus.lsp4e.internal.JDTUtilsImpl;

import com.google.gson.Gson;
import com.redhat.microprofile.commons.DocumentFormat;
import com.redhat.microprofile.commons.MicroProfileProjectInfo;
import com.redhat.microprofile.commons.MicroProfilePropertiesScope;
import com.redhat.microprofile.jdt.core.PropertiesManager;

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
				"file:///c%3A/Users/azerr/git/quarkus-quickstarts/hibernate-orm-resteasy/src/test/resources/application.properties");

		file = JDTUtils.findFile(
				"file:///c%3A/Users/azerr/git/quarkus-ls/microprofile.jdt/com.redhat.microprofile.jdt.test/projects/maven/all-quarkus-extensions/src/main/resources/application.properties");

//		file = JDTUtils.findFile(
//				"file:///c%3A/Users/azerr/git/quarkus-quickstarts/config-quickstart/src/main/resources/application.properties");

//		file = JDTUtils.findFile(
//				"file:///c%3A/Users/azerr/git/quarkus-quickstarts/rest-client-quickstart/src/main/resources/application.properties");

//		 file = JDTUtils.findFile(
//		 "file:///c%3A/Users/azerr/git/quarkus-ls/microprofile.jdt/com.redhat.microprofile.jdt.test/projects/maven/rest-client-quickstart/src/main/resources/application.properties");

		file = JDTUtils.findFile(
				"file:///c%3A/Users/azerr/git/quarkus-ls/microprofile.jdt/com.redhat.microprofile.jdt.test/projects/maven/kubernetes/src/main/resources/application.properties");

		try {
			MicroProfileProjectInfo info = PropertiesManager.getInstance().getMicroProfileProjectInfo(file,
					MicroProfilePropertiesScope.SOURCES_AND_DEPENDENCIES, JDTUtilsImpl.getInstance(),
					DocumentFormat.Markdown, new NullProgressMonitor());
			String s = new Gson().toJson(info);
			System.err.println(s);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		IMember location;
		try {
			location = PropertiesManager.getInstance().findDeclaredProperty(file,
					"org.acme.config.IGreetingConfiguration", null, "getName()QOptional<QString;>;",
					new NullProgressMonitor());
			System.err.println(location);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
