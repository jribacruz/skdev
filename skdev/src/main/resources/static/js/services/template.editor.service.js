(function() {
	'use strict';

	angular.module("skdevMD").factory('templateEditorSV', templateEditorSV);

	templateEditorSV.$inject = [ '$log', '$mdToast' ];

	/**
	 * 
	 * @param $log
	 * @param $mdToast
	 * @returns
	 */
	function templateEditorSV($log, $mdToast) {
		$log.debug('[templateEditorSV] Inicializando... ');

		var editor = {};

		var service = {
			init : init,
			setValue : setValue,
			getValue : getValue
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

		return service;
	}

})();