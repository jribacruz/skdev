(function() {
	'use strict';

	angular.module("skdevMD").factory('templateEditorSV', templateEditorSV);

	templateEditorSV.$inject = [ '$log', '$mdToast', '$mdDialog' ];

	/**
	 * 
	 * @param $log
	 * @param $mdToast
	 * @returns
	 */
	function templateEditorSV($log, $mdToast, $mdDialog) {
		$log.debug('[templateEditorSV] Inicializando... ');

		var editor = {};

		var service = {
			init : init,
			setValue : setValue,
			getValue : getValue,
			getEditor : getEditor,
			showTemplateInfo: showTemplateInfo,
			showTemplateEditor: showTemplateEditor
		};

		function init() {
			$log.debug('[TemplateEditorCT] Inicializando editor de templates...');
			editor = CodeMirror(document.getElementById('templateEditor'), {
				mode : "handlebars",
				lineNumbers : true,
				theme : 'eclipse',
				styleActiveLine : true
			});
			editor.setSize('100%', '100%');
		}

		function setValue(text) {
			editor.setValue(text);
		}

		function getValue() {
			return editor.getValue();
		}

		function getEditor() {
			return editor;
		}
		
		function showTemplateInfo() {
			return $mdDialog.show({
				parent : angular.element(document.body),
				contentElement : '#templateInfoDialog',
				clickOutsideToClose : false
			});
		}
		
		function showTemplateEditor() {
			return $mdDialog.show({
				parent : angular.element(document.body),
				contentElement : '#templateEditorDialog',
				clickOutsideToClose : false
			});
		}

		return service;
	}

})();