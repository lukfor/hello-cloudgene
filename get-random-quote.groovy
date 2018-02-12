import genepi.hadoop.common.WorkflowContext
import groovy.json.JsonSlurper


def run(WorkflowContext context) {

  def quotes = context.getConfig("quotes") as int;

  def url = new URL("https://gist.githubusercontent.com/robatron/a66acc0eed3835119817/raw/0e216f8b6036b82de5fdd93526e1d496d8e1b412/quotes.txt")
  def content = url.getText()
  def lines = content.split("\n")

  for (int i = 1; i <= quotes; i++){
    context.beginTask("Generating quote.... ");
    sleep(7000);
    int random = new Random().nextInt(lines.length); // get random line number
    String randomLine = lines[random]; // get random line
    context.endTask("#" + i + " " + randomLine, WorkflowContext.OK);
  }
	return true;
}
