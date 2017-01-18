(function() {
	'use strict';

	angular.module("skdevMD").factory('executeJSTemplateSV', executeJSTemplateSV);

	executeJSTemplateSV.$inject = [ '$log', '$http', 'executeJSConsoleSV' ];

	/**
	 * 
	 * @param $log
	 * @param $resource
	 * @returns
	 */
	function executeJSTemplateSV($log, $http, executeJSConsoleSV) {
		$log.debug('[executeJSTemplateSV] Inicializando... ');

		var templates = [];

		var service = {
			merge : merge,
			setTemplates : setTemplates,
			get : get
		};

		return service;

		function setTemplates(templateList) {
			templates = templateList;
		}

		function merge(template, model) {
			$log.debug('[executeJSTemplateSV] Iniciando processo de merge...' + template);
			if (template) {
				if (angular.isObject(template)) {
					return _mergeObject(template, model);
				}
				return _mergeString(template, model);
			}
			console.log('ERROR')
			executeJSConsoleSV.error(format('Template {} não definido', template));
			return null;
		}

		function _mergeObject(template, model) {
			console.log(template);
			$log.debug('[executeJSTemplateSV] merge/object')
			var hbTemplate = Handlebars.compile(template.content);
			var result = hbTemplate(model);
			executeJSConsoleSV.info(format('Merge do template {}', template.name), {
				invoker : '$template.merge',
				details : [ {
					header : 'input',
					content : template.content
				}, {
					header : 'model',
					content : JSON.stringify(model, null, 4)
				}, {
					header : 'output',
					content : result
				} ]
			});
			return result;
		}

		function _mergeString(template, model) {
			$log.debug('[executeJSTemplateSV] merge/string');
			var template = Handlebars.compile(template);
			var result = template(model);
			return result;
		}

		function get(name) {
			var eTemplate = {}; 
			angular.forEach(templates, function(template) {
				if (template.name === name) {
					eTemplate = template;
				}
			});
			return eTemplate;
		}

	}

})();