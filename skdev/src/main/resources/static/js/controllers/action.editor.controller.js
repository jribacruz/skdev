(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionEditorCT', ActionEditorCT);

	ActionEditorCT.$inject = [ '$scope', '$log' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param ProjectSV
	 * @param $mdDialog
	 * @param $http
	 * @param HttpSV
	 * @returns
	 */
	function ActionEditorCT($scope, $log) {
		$log.debug('[ActionEditorCT] Inicializando...');
		var self = this;

		var editors = {};

		init();
		
		self.showJS = showJS;
		
		self.showHTML = showHTML;
		
		function showJS() {
			editors['editor'].setContents("var foo;", "application/javascript");
		}
		
		function showHTML() {
			editors['editor'].setContents("<html></html>", "text/html");
		}

		function init() {
			editors['editor'] = new orion.codeEdit();
			editors['editor'].create({
				parent : "editorId",
				contentType : "text/html",
				contents : "",
				noFocus: true
			}).then(function(editorViewer) {
				editors['editor'] = editorViewer;
				if (editorViewer.settings) {
					editorViewer.settings.contentAssistAutoTrigger = true;
					editorViewer.settings.showOccurrences = true;
				}
			});
		}
	}
})();
