self.addEventListener("install", event => {
  console.log("[SW] Service Worker instalado");
  self.skipWaiting();
});

self.addEventListener("activate", event => {
  console.log("[SW] Ativado e pronto para controlar páginas.");
});

self.addEventListener("fetch", event => {
  // comportamento padrão: só loga
  // você pode fazer cache aqui se quiser
  console.log("[SW] Fetch interceptado:", event.request.url);
});
