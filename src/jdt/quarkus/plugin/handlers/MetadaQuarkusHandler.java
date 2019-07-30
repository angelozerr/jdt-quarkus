package jdt.quarkus.plugin.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.gson.Gson;

import jdt.quarkus.JDTQuarkusManager;
import jdt.quarkus.ExtendedConfigDescriptionBuildItem;

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
		List<ExtendedConfigDescriptionBuildItem> properties =   JDTQuarkusManager.getInstance().getQuarkusProperties();
		String s = new Gson().toJson(properties);
		System.err.println(s);
		return null;
	}

}
